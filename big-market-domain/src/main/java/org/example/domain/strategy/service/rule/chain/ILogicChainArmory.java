package org.example.domain.strategy.service.rule.chain;

/**
 * @ClassName ILogicChainArmory
 * @Description 装配接口
 * @Author @O_o
 * @Date 2025/2/18 14:19
 * @Version 1.0
 */

public interface ILogicChainArmory {
    ILogicChain appendNext(ILogicChain next);
    ILogicChain next();
}
