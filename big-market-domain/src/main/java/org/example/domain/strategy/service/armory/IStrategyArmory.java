package org.example.domain.strategy.service.armory;

/**
 * @ClassName IStrategryArmory
 * @Description 策略装配库（兵工厂），负责初始化策略计算
 * @Author @O_o
 * @Date 2025/1/30 22:36
 * @Version 1.0
 */

public interface IStrategyArmory {
    boolean assembleLotteryStrategy(Long strategyId);


}
