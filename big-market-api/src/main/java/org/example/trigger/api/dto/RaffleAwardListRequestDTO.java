package org.example.trigger.api.dto;


import lombok.Data;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 抽奖奖品列表，请求对象
 * @create 2024-02-14 09:46
 */
@Data
public class RaffleAwardListRequestDTO {


    // 活动ID
    private Long activityId;
    // 用户ID
    private String userId;

}

