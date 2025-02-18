package org.example.test.domain;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.service.armory.IStrategyArmory;
import org.example.domain.strategy.service.armory.IStrategyDispatch;
import org.example.domain.strategy.service.armory.StrategyArmoryDispatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName IstrategyArmory
 * @Description
 * @Author @kimwonjoon
 * @Date 2025/1/31 00:51
 * @Version 1.0
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyArmoryTest {

    @Resource
   private IStrategyArmory strategyArmory;

    @Resource
    private IStrategyDispatch strategyDispatch;

    @Test
    public void test() {
        strategyArmory.assembleLotteryStrategy(100001L);
    }
    @Test
    public void test2() {
        log.info(strategyDispatch.getRandomAwardId(100001L,"4000:102,103,104,105").toString());
        log.info(strategyDispatch.getRandomAwardId(100001L,"5000:102,103,104,105,106,107").toString());
        log.info(strategyDispatch.getRandomAwardId(100001L,"6000:102,103,104,105,106,107,108,109").toString());


    }

}
