package org.example.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.DailyBehaviorRebate;

import java.util.List;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 日常行为返利活动配置
 * @create 2024-04-30 13:48
 */
@Mapper
public interface IDailyBehaviorRebateDao {

    List<org.example.infrastructure.persistent.po.DailyBehaviorRebate> queryDailyBehaviorRebateByBehaviorType(String behaviorType);

}
