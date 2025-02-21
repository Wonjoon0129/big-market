package org.example.domain.strategy.service.armory;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.model.entity.StrategyAwardEntity;
import org.example.domain.strategy.model.entity.StrategyEntity;
import org.example.domain.strategy.model.entity.StrategyRuleEntity;
import org.example.domain.strategy.repository.IStrategyRepository;
import org.example.types.common.Constants;
import org.example.types.enums.ResponseCode;
import org.example.types.exception.AppException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.*;

/**
 * @ClassName IStrategryArmory
 * @Description 策略装配库（兵工厂），负责初始化策略计算
 * @Author @O_o
 * @Date 2025/1/30 22:36
 * @Version 1.0
 */
@Slf4j
@Service
public class StrategyArmoryDispatch implements IStrategyArmory,IStrategyDispatch {

    @Resource
    private IStrategyRepository repository;

    @Override
    public boolean assembleLotteryStrategy(Long strategyId) {

        //1.查询策略配置
        List<StrategyAwardEntity> strategyAwardEntities=repository.queryStrategyAwardList(strategyId);

        //2.缓存奖品库存【用于 decr 扣减库存使用】
        for(StrategyAwardEntity strategyAward:strategyAwardEntities){
            Integer awardId=strategyAward.getAwardId();
            Integer awardCount=strategyAward.getAwardCount();
            cacheStrategyAwardCount(strategyId,awardId,awardCount);
        }

        //3.1默认装配配置【全量抽奖概率】
        assembleLotteryStrategy(String.valueOf(strategyId), strategyAwardEntities);

        //3.2 权重策略配置-适用于 rule_weight 权重规则配置
        StrategyEntity strategyEntity=repository.queryStrategyEntityBuStrategyId(strategyId);
        String ruleWeight = strategyEntity.getRuleWeight();
        if(null==ruleWeight){ return true;}

        StrategyRuleEntity strategyRuleEntity=repository.queryStrategyRule(strategyId,ruleWeight);
        if(null==strategyRuleEntity){
            throw new AppException(ResponseCode.STRATEGY_RULE_WEIGHT_IS_NULL.getCode(),ResponseCode.STRATEGY_RULE_WEIGHT_IS_NULL.getInfo());
        }

        Map<String, List<Integer>> ruleWeightValuesMap = strategyRuleEntity.getRuleWeightValues();
        Set<String> keys = ruleWeightValuesMap.keySet();
        for(String key:keys){
            List<Integer> values = ruleWeightValuesMap.get(key);
            ArrayList<StrategyAwardEntity> strategyAwardEntitiesClone = new ArrayList<>(strategyAwardEntities);
            strategyAwardEntitiesClone.removeIf(entity->!values.contains(entity.getAwardId()));
            assembleLotteryStrategy(String.valueOf(strategyId).concat("_").concat(key), strategyAwardEntitiesClone);

        }

        return  true;

    }

    private void cacheStrategyAwardCount(Long strategyId, Integer awardId, Integer awardCount) {
        String cacheKey = Constants.RedisKey.STRATEGY_AWARD_COUNT_KEY + strategyId + Constants.UNDERLINE + awardId;
        repository.cacheStrategyAwardCount(cacheKey, awardCount);

    }

    private void assembleLotteryStrategy(String key,List<StrategyAwardEntity> strategyAwardEntities){
        //1.获取最小概率值
        BigDecimal minAwardRate = strategyAwardEntities.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
        //2.获取概率值的总和
        BigDecimal totalAwardRate = strategyAwardEntities.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        //3.用 1%0.0001获取概率范围，百分位，千分位，万分位
        BigDecimal rateRange = totalAwardRate.divide(minAwardRate, 0, RoundingMode.CEILING);

        //4.生成策略奖品概率查找表
        ArrayList<Integer> strategyAwardSearchRateTables=new ArrayList<>(rateRange.intValue());
        for(StrategyAwardEntity strategyAward : strategyAwardEntities) {
            Integer awardId = strategyAward.getAwardId();
            BigDecimal awardRate = strategyAward.getAwardRate();

            for(int i=0;i<rateRange.multiply(awardRate).setScale(0, RoundingMode.CEILING).intValue();i++){
                strategyAwardSearchRateTables.add(awardId);
            }
        }
        //5.乱序
        Collections.shuffle(strategyAwardSearchRateTables);
        //6.转换为集合
        Map<Integer, Integer> shuffleStrategyAwardSearchRateTables = new LinkedHashMap<>();
        for(int i=0;i<strategyAwardSearchRateTables.size();i++){
            shuffleStrategyAwardSearchRateTables.put(i,strategyAwardSearchRateTables.get(i));
        }

        // 7.存储到 Redis
        repository.storeStrategyAwardSearchTables(key,shuffleStrategyAwardSearchRateTables.size(),shuffleStrategyAwardSearchRateTables);
    }

    @Override
    public Integer getRandomAwardId(Long strategyId) {
        int rateRange=repository.getRateRange(strategyId);
        return repository.getStrategyAwardAssemble(String.valueOf(strategyId),new SecureRandom().nextInt(rateRange));
    }

    @Override
    public Integer getRandomAwardId(Long strategyId, String ruleWeightValue) {
        String key=String.valueOf(strategyId).concat("_").concat(ruleWeightValue);
        int rateRange=repository.getRateRange(key);
        return repository.getStrategyAwardAssemble(key,new SecureRandom().nextInt(rateRange));
    }

    @Override
    public Boolean subtractionAwardStock(Long strategyId, Integer awardId) {
        String cacheKey = Constants.RedisKey.STRATEGY_AWARD_COUNT_KEY + strategyId + Constants.UNDERLINE + awardId;
        return repository.subtractionAwardStock(cacheKey, awardId);
    }
}
