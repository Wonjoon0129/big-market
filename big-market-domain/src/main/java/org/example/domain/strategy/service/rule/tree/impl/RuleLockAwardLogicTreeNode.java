package org.example.domain.strategy.service.rule.tree.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.award.repository.IAwardRepository;
import org.example.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import org.example.domain.strategy.repository.IStrategyRepository;
import org.example.domain.strategy.service.rule.tree.ILogicTreeNode;
import org.example.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName RuleLockAwardLogicTreeNode
 * @Description 兜底奖励节点
 * @Author @kimwonjoon
 * @Date 2025/2/18 21:01
 * @Version 1.0
 */
@Slf4j
@Component("rule_lock")
public class RuleLockAwardLogicTreeNode implements ILogicTreeNode {

    // 用户抽奖次数，后续完成这部分流程开发的时候，从数据库/Redis中读取
    private Long userRaffleCount = 10L;
    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId, String ruleValue) {
        log.info("规则过滤-次数锁 userId:{} strategyId:{} awardId:{}", userId, strategyId, awardId);

        long raffleCount = 0L;
        try {
            raffleCount = Long.parseLong(ruleValue);
        } catch (Exception e) {
            throw new RuntimeException("规则过滤-次数锁异常 ruleValue: " + ruleValue + " 配置不正确");
        }
        Integer userRaffleCount=strategyRepository.queryTodayUserRaffleCount(userId, strategyId);

        // 用户抽奖次数大于规则限定值，规则放行
        if (userRaffleCount >= raffleCount) {
            log.info("规则过滤-次数锁【放行】 userId:{} strategyId:{} awardId:{} raffleCount:{} userRaffleCount:{}", userId, strategyId, awardId, userRaffleCount, userRaffleCount);
            return DefaultTreeFactory.TreeActionEntity.builder()
                    .ruleLogicCheckType(RuleLogicCheckTypeVO.ALLOW)
                    .build();
        }


        // 用户抽奖次数小于规则限定值，规则拦截
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .build();
    }
}
