package org.example.domain.award.service;

import org.example.domain.award.model.entity.UserAwardRecordEntity;

/**
 * @ClassName IAwardService
 * @Description 奖品服务接口
 * @Author @O_o
 * @Date 2025/2/24 23:09
 * @Version 1.0
 */

public interface IAwardService {
    void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity);

}
