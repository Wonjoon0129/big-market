package org.example.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.RaffleActivitySku;

import java.util.List;

/**
 * @ClassName IRaffleActivitySkuDao
 * @Description TODO
 * @Author @O_o
 * @Date 2025/2/22 13:36
 * @Version 1.0
 */
@Mapper
public interface IRaffleActivitySkuDao {
    RaffleActivitySku queryActivitySku(Long sku);

    void updateActivitySkuStock(Long sku);

    void clearActivitySkuStock(Long sku);

    List<RaffleActivitySku> queryActivitySkuListByActivityId(Long activityId);
}
