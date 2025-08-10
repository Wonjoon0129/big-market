package org.example.domain.strategy.service.armory.algorithm.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.model.entity.StrategyAwardEntity;
import org.example.domain.strategy.service.armory.algorithm.AbstractAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * @ClassName O1Algorithm
 * @Description
 * @Author @kimwonjoon
 * @Date 2025/8/8 17:50
 */

@Slf4j
@Component("o1Algorithm")
public class O1Algorithm extends AbstractAlgorithm {

    @Override
    public void armoryAlgorithm(String key, List<StrategyAwardEntity> strategyAwardEntities, BigDecimal rateRange) {
        log.info("抽奖算法 O(1) 装配 key:{}", key);
        // 1. 生成策略奖品概率查找表「这里指需要在list集合中，存放上对应的奖品占位即可，占位越多等于概率越高」
        List<Integer> strategyAwardSearchRateTables = new ArrayList<>(rateRange.intValue());
        for (StrategyAwardEntity strategyAward : strategyAwardEntities) {
            Integer awardId = strategyAward.getAwardId();
            BigDecimal awardRate = strategyAward.getAwardRate();
            // 计算出每个概率值需要存放到查找表的数量，循环填充
            for (int i = 0; i < rateRange.multiply(awardRate).intValue(); i++) {
                strategyAwardSearchRateTables.add(awardId);
            }
        }

        // 2. 对存储的奖品进行乱序操作
        Collections.shuffle(strategyAwardSearchRateTables);

        // 3. 生成出Map集合，key值，对应的就是后续的概率值。通过概率来获得对应的奖品ID
        Map<Integer, Integer> shuffleStrategyAwardSearchRateTable = new LinkedHashMap<>();
        for (int i = 0; i < strategyAwardSearchRateTables.size(); i++) {
            shuffleStrategyAwardSearchRateTable.put(i, strategyAwardSearchRateTables.get(i));
        }

        // 4. 存放到 Redis
        repository.storeStrategyAwardSearchRateTable(key, shuffleStrategyAwardSearchRateTable.size(), shuffleStrategyAwardSearchRateTable);
    }

    @Override
    public Integer dispatchAlgorithm(String key) {
        log.info("抽奖算法 O(1) 抽奖计算 key:{}", key);
        // 分布式部署下，不一定为当前应用做的策略装配。也就是值不一定会保存到本应用，而是分布式应用，所以需要从 Redis 中获取。
        int rateRange = repository.getRateRange(key);
        // 通过生成的随机值，获取概率值奖品查找表的结果
        return repository.getStrategyAwardAssemble(key, secureRandom.nextInt(rateRange));
    }

}