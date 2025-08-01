package org.example.domain.strategy.service.rule.tree.factory.engine;

import org.example.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

import java.util.Date;

/**
 * @ClassName IDecisionTreeEngine
 * @Description 规则树组合接口
 * @Author @O_o
 * @Date 2025/2/18 21:07
 * @Version 1.0
 */

public interface IDecisionTreeEngine {
    DefaultTreeFactory.StrategyAwardVO process(String userId, Long strategyId, Integer awardId, Date endDateTime);
}
