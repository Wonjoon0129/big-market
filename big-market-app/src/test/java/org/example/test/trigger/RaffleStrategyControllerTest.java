package org.example.test.trigger;

import org.example.trigger.api.IRaffleStrategyService;
import org.example.trigger.api.dto.RaffleAwardListRequestDTO;
import org.example.trigger.api.dto.RaffleAwardListResponseDTO;
import org.example.trigger.api.dto.RaffleStrategyRuleWeightRequestDTO;
import org.example.trigger.api.dto.RaffleStrategyRuleWeightResponseDTO;
import org.example.types.model.Response;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 营销抽奖服务测试
 * @create 2024-04-20 10:41
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleStrategyControllerTest {

    @Resource
    private IRaffleStrategyService raffleStrategyService;

    @Test
    public void test_queryRaffleAwardList() {
        RaffleAwardListRequestDTO request = new RaffleAwardListRequestDTO();
        request.setUserId("xiaofuge");
        request.setActivityId(100301L);
        Response<List<RaffleAwardListResponseDTO>> response = raffleStrategyService.queryRaffleAwardList(request);

        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_queryRaffleStrategyRuleWeight() {

        RaffleStrategyRuleWeightRequestDTO request = new RaffleStrategyRuleWeightRequestDTO();
        request.setUserId("xiaofuge");
        request.setActivityId(100301L);

        Response<List<RaffleStrategyRuleWeightResponseDTO>> response = raffleStrategyService.queryRaffleStrategyRuleWeight(request);
        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }


}
