package org.example.domain.strategy.service.armory.algorithm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.strategy.repository.IStrategyRepository;

import javax.annotation.Resource;
import java.security.SecureRandom;

/**
 * @ClassName AbstractAlgoritm
 * @Description
 * @Author @kimwonjoon
 * @Date 2025/8/8 17:51
 */

public abstract class AbstractAlgorithm implements IAlgorithm {

    @Resource
    protected IStrategyRepository repository;

    protected final SecureRandom secureRandom = new SecureRandom();

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public enum Algorithm {
        O1("o1Algorithm"),
        OLogN("oLogNAlgorithm");

        private String key;
    }
}
