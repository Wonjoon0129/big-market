package org.example.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.UserAwardRecord;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 用户中奖记录表
 * @create 2024-04-03 15:57
 */
@DBRouterStrategy(splitTable = true)
@Mapper
public interface IUserAwardRecordDao {
    void insert(UserAwardRecord userAwardRecord);

    int updateAwardRecordCompletedState(UserAwardRecord userAwardRecordReq);
}
