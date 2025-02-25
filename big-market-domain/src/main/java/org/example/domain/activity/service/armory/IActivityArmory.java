package org.example.domain.activity.service.armory;

/**
 * @ClassName IActivityArmory
 * @Description 活动装配预热
 * @Author @O_o
 * @Date 2025/2/23 14:13
 * @Version 1.0
 */

public interface IActivityArmory {
    boolean assembleActivitySku(Long sku);

    boolean assembleActivitySkuByActivityId(Long activityId);
}
