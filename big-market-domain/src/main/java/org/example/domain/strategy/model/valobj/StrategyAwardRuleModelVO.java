package org.example.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.types.common.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StrategyAwardRuleModelVO
 * @Description 抽奖策略规则规则值对象；值对象，没有唯一ID，仅限于从数据库查询对象
 * @Author @kimwonjoon
 * @Date 2025/2/17 22:48
 * @Version 1.0
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardRuleModelVO {

    private String ruleModels;

}
