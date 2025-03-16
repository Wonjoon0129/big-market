package org.example.domain.strategy.service.raffle;

import org.example.domain.strategy.model.entity.RaffleAwardEntity;
import org.example.domain.strategy.model.entity.RaffleFactorEntity;

/**
 * @ClassName IRaffleStrategy
 * @Description 抽奖策略接口
 * @Author @O_o
 * @Date 2025/2/16 19:57
 * @Version 1.0
 */

public interface IRaffleStrategy {
    RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity);
}
