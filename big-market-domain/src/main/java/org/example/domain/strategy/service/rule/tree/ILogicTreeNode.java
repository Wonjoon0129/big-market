package org.example.domain.strategy.service.rule.tree;

import org.example.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @ClassName ILogicTreeNode
 * @Description 规则树接口
 * @Author @O_o
 * @Date 2025/2/18 20:58
 * @Version 1.0
 */

public interface ILogicTreeNode {
    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId);
}
