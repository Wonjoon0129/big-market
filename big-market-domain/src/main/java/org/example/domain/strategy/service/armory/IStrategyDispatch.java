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
}
