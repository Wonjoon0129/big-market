package org.example.domain.award.repository;

import org.example.domain.award.model.aggregate.UserAwardRecordAggregate;

/**
 * @ClassName IAwardRepository
 * @Description 奖品仓储服务
 * @Author @O_o
 * @Date 2025/2/24 23:09
 * @Version 1.0
 */

public interface IAwardRepository {
    void saveUserAwardRecord(UserAwardRecordAggregate userAwardRecordAggregate);
}
