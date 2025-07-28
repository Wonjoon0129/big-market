package org.example.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.activity.model.valobj.OrderTradeTypeVO;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 活动商品充值实体对象
 * @create 2024-03-16 08:53
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkuRechargeEntity {

    /** 用户ID */
    private String userId;
    /** 商品SKU - activity + activity count */
    private Long sku;
    /** 外部业务号 */
    private String outBusinessNo;
    /** 用户ID */
    private OrderTradeTypeVO orderTradeType = OrderTradeTypeVO.rebate_no_pay_trade;


}
