package org.example.domain.strategy.service.armory;

/**
 * @ClassName IStrategyDispath
 * @Description 策略抽奖调度
 * @Author @kimwonjoon
 * @Date 2025/1/31 23:03
 * @Version 1.0
 */

public interface IStrategyDispatch {

    Integer getRandomAwardId(Long strategyId);

    Integer getRandomAwardId(Long strategyId,String ruleWeightValue);
    /**
     * 根据策略ID和奖品ID，扣减奖品缓存库存
     *
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return 扣减结果
     */
    Boolean subtractionAwardStock(Long strategyId, Integer awardId);

}
