package org.example.domain.strategy.repository;

import org.example.domain.strategy.model.entity.StrategyAwardEntity;
import org.example.domain.strategy.model.entity.StrategyEntity;
import org.example.domain.strategy.model.entity.StrategyRuleEntity;
import org.example.domain.strategy.model.valobj.RuleTreeVO;
import org.example.domain.strategy.model.valobj.RuleWeightVO;
import org.example.domain.strategy.model.valobj.StrategyAwardRuleModelVO;
import org.example.domain.strategy.model.valobj.StrategyAwardStockKeyVO;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName IStrategyRepository
 * @Description 策略仓储接口
 * @Author @kimwonjoon
 * @Date 2025/1/30 22:44
 * @Version 1.0
 */

public interface IStrategyRepository {
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    <K, V> Map<K, V> getMap(String key);

    int getRateRange(Long strategyId);

    int getRateRange(String key);

    Integer getStrategyAwardAssemble(String key, int i);

    StrategyEntity queryStrategyEntityBuStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, String ruleModel);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyAwardRuleModelVO queryStrategyAwardRuleModelVO(Long strategyId, Integer awardId);

    RuleTreeVO queryRuleTreeVOByTreeId(String treeId);

    void cacheStrategyAwardCount(String cacheKey, Integer awardCount);

    /**
     * 写入奖品库存消费队列
     *
     * @param strategyAwardStockKeyVO 对象值对象
     */
    void awardStockConsumeSendQueue(StrategyAwardStockKeyVO strategyAwardStockKeyVO);

    StrategyAwardStockKeyVO takeQueueValue();

    void updateStrategyAwardStock(Long strategyId, Integer awardId);

    StrategyAwardEntity queryStrategyAwardEntity(Long strategyId, Integer awardId);

    Long queryStrategyIdByActivityId(Long activityId);

    Integer queryTodayUserRaffleCount(String userId, Long strategyId);

    Map<String, Integer> queryAwardRuleLockCOunt(String[] treeIds);

    Integer queryActivityAccountTotalUseCount(String userId, Long strategyId);

    List<RuleWeightVO> queryAwardRuleWeight(Long strategyId);

    <K, V> void storeStrategyAwardSearchRateTable(String key, Integer rateRange, Map<K, V> strategyAwardSearchRateTable);

    /**
     * 存储抽奖策略对应的Bean算法
     *
     * @param key      策略ID
     * @param beanName 策略对象名称
     */
    void cacheStrategyArmoryAlgorithm(String key, String beanName);

    /**
     * 获取存储抽奖策略对应的Bean算法
     *
     * @param key 策略ID
     * @return 策略对象名称
     */
    String queryStrategyArmoryAlgorithmFromCache(String key);

    /**
     * 缓存key，decr 方式扣减库存
     *
     * @param cacheKey 缓存Key
     * @return 扣减结果
     */
    Boolean subtractionAwardStock(String cacheKey);

    /**
     * 缓存key，decr 方式扣减库存
     *
     * @param cacheKey    缓存Key
     * @param endDateTime 活动结束时间
     * @return 扣减结果
     */
    Boolean subtractionAwardStock(String cacheKey, Date endDateTime);

}
