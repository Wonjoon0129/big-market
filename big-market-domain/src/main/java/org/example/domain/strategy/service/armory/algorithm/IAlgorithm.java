package org.example.domain.strategy.service.armory.algorithm;

import org.example.domain.strategy.model.entity.StrategyAwardEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName IAlgorithm
 * @Description
 * @Author @kimwonjoon
 * @Date 2025/8/8 17:51
 */

public interface IAlgorithm {

    void armoryAlgorithm(String key, List<StrategyAwardEntity> strategyAwardEntities, BigDecimal rateRange);

    Integer dispatchAlgorithm(String key);
}
