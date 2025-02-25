package org.example.trigger.api;

import org.example.trigger.api.dto.RaffleAwardListRequestDTO;
import org.example.trigger.api.dto.RaffleAwardListResponseDTO;
import org.example.trigger.api.dto.RaffleStrategyRequestDTO;
import org.example.trigger.api.dto.RaffleStrategyResponseDTO;
import org.example.types.model.Response;

import java.util.List;

/**
 * @ClassName IRaffleService
 * @Description 抽奖服务接口
 * @Author @kimwonjoon
 * @Date 2025/2/21 10:35
 * @Version 1.0
 */

public interface IRaffleStrategyService {
    /**
     * 策略装配接口
     * @param strategyId 策略ID
     * @return 装配结果
     */
    Response<Boolean> strategyArmory(Long strategyId);
    /**
     * 查询策略下所有奖品列表
     * @param requestDTO 查询参数
     * @return 奖品列表
     */
    Response<List<RaffleAwardListResponseDTO>> queryRaffleAwardList(RaffleAwardListRequestDTO requestDTO);

    Response<RaffleStrategyResponseDTO> randomRaffle(RaffleStrategyRequestDTO requestDTO);


}
