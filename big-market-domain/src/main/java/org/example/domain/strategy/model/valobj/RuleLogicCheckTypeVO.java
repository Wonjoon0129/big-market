package org.example.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName RuleLogicCheckTypeVO
 * @Description 规则过滤校验类型值对象
 * @Author @kimwonjoon
 * @Date 2025/2/16 21:18
 * @Version 1.0
 */

@Getter
@AllArgsConstructor
public enum RuleLogicCheckTypeVO {

    ALLOW("0000", "放行；执行后续的流程，不受规则引擎影响"),
    TAKE_OVER("0001","接管；后续的流程，受规则引擎执行结果影响"),
    ;

    private final String code;
    private final String info;

}

