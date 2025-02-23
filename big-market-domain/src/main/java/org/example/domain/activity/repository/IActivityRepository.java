package org.example.domain.activity.repository;

import org.example.domain.activity.model.aggregate.CreateOrderAggregate;
import org.example.domain.activity.model.entity.ActivityCountEntity;
import org.example.domain.activity.model.entity.ActivityEntity;
import org.example.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 活动仓储接口
 * @create 2024-03-16 10:31
 */
public interface IActivityRepository {
    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

    void saveOrder(CreateOrderAggregate createOrderAggregate);
}
