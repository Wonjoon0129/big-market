package org.example.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

//奖品表
@Data
public class Award {

    //自增 ID
    private Long id;
    // 抽奖奖品 ID-内部流转使用
    private Integer awardId;
    //奖品对接标识-每一个都是一个对应的发奖策略
    private String awardKey;
    //奖品配置信息
    private String awardConfig;
    //奖品内部描述
    private String awardDesc;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

}
