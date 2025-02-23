package org.example.domain.activity.service.rule;

import org.example.domain.activity.model.entity.ActivityCountEntity;
import org.example.domain.activity.model.entity.ActivityEntity;
import org.example.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @ClassName IActionChain
 * @Description TODO
 * @Author @O_o
 * @Date 2025/2/22 15:06
 * @Version 1.0
 */

public interface IActionChain extends IActionChainArmory {
    boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity);}
