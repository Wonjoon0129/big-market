package org.example.domain.activity.service.quota.rule.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.domain.activity.service.quota.rule.IActionChain;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName DefaultActivityChainFactory
 * @Description
 * @Author @kimwonjoon
 * @Date 2025/2/22 15:15
 * @Version 1.0
 */


    /**
     * @author Fuzhengwei bugstack.cn @小傅哥
     * @description 责任链工厂
     * @create 2024-03-23 10:30
     */
    @Service
    public class DefaultActivityChainFactory {

        private final IActionChain actionChain;

        /**
         * 1. 通过构造函数注入。
         * 2. Spring 可以自动注入 IActionChain 接口实现类到 map 对象中，key 就是 bean 的名字。
         * 3. 活动下单动作的责任链是固定的，所以直接在构造函数中组装即可。
         */
        public DefaultActivityChainFactory(Map<String, IActionChain> actionChainGroup) {
            actionChain = actionChainGroup.get(ActionModel.activity_base_action.code);
            actionChain.appendNext(actionChainGroup.get(ActionModel.activity_sku_stock_action.getCode()));

        }

        public IActionChain openActionChain() {
            return this.actionChain;
        }

        @Getter
        @AllArgsConstructor
        public enum ActionModel {

            activity_base_action("activity_base_action", "活动的库存、时间校验"),
            activity_sku_stock_action("activity_sku_stock_action", "活动sku库存"),
            ;

            private final String code;
            private final String info;

        }

    }