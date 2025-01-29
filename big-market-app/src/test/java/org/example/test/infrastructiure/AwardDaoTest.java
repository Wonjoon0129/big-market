package org.example.test.infrastructiure;

import lombok.extern.slf4j.Slf4j;
import org.example.infrastructure.persistent.dao.IAwardDao;
import org.example.infrastructure.persistent.po.Award;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName AwardDaoTest
 *@Description  奖品持久化单元测试
 *@Author @kimwonjoon
 *@Date 2025/1/29 17:45
 *@Version 1.0
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardDaoTest {
    @Resource
    private IAwardDao awardDao;
    @Test
    public void test_queryAwardList(){
        List<Award> awards =awardDao.queryAwardList();
        log.info(awards.toString());
    }
}
