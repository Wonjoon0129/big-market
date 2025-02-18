package org.example.domain.strategy.service.rule.chain;

/**
 * @ClassName ILogicChain
 * @Description 责任链接口
 * @Author @kimwonjoon
 * @Date 2025/2/18 13:19
 * @Version 1.0
 */

public interface ILogicChain extends ILogicChainArmory{

    /**
     * 责任链接口
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @return 奖品ID
     */
    Integer logic(String userId, Long strategyId);



}
