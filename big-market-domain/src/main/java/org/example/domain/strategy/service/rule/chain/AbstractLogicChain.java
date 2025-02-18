package org.example.domain.strategy.service.rule.chain;

/**
 * @ClassName AbstractLogicChain
 * @Description
 * @Author @kimwonjoon
 * @Date 2025/2/18 13:23
 * @Version 1.0
 */

public abstract class AbstractLogicChain implements ILogicChain {

    private ILogicChain next;

    @Override
    public ILogicChain appendNext(ILogicChain next) {
        this.next=next;
        return next;
    }

    @Override
    public ILogicChain next() {
        return next;
    }

    protected abstract String ruleModel();
}
