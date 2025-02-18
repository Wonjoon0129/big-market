package org.example.domain.strategy.service.rule.filter;

import org.example.domain.strategy.model.entity.RuleActionEntity;
import org.example.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @ClassName ILogicFilter
 * @Description 抽奖规则过滤接口
 * @Author @O_o
 * @Date 2025/2/16 20:11
 * @Version 1.0
 */

public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {

    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);
}
