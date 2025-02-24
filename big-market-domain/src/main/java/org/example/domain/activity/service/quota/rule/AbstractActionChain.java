package org.example.domain.activity.service.quota.rule;

/**
 * @ClassName AbstractActionChain
 * @Description
 * @Author @kimwonjoon
 * @Date 2025/2/22 15:12
 * @Version 1.0
 */
public abstract class AbstractActionChain implements IActionChain{
    private IActionChain next;

    @Override
    public IActionChain next() {
        return next;
    }

    @Override
    public IActionChain appendNext(IActionChain next) {
        this.next = next;
        return next;
    }

}
