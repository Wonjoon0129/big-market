package org.example.infrastructure.persistent.po;

/**
 * @ClassName RaffleActivitySku
 * @Description
 * @Author @kimwonjoon
 * @Date 2025/2/22 13:34
 * @Version 1.0
 */

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 抽奖活动sku持久化对象
 * @create 2024-03-16 10:54
 */
@Data
public class RaffleActivitySku {
    private Long id;
    /**
     * 商品sku
     */
    private Long sku;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 活动个人参与次数ID
     */
    private Long activityCountId;
    /**
     * 库存总量
     */
    private Integer stockCount;
    /**
     * 剩余库存
     */
    private Integer stockCountSurplus;
    /**
     * 商品金额【积分】
     */
    private BigDecimal productAmount;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
