package org.example.domain.activity.service;

import org.example.domain.activity.model.valobj.ActivitySkuStockKeyVO;

/**
 * @ClassName ISkuStock
 * @Description 活动 sku 库存处理接口
 * @Author @O_o
 * @Date 2025/2/23 15:24
 * @Version 1.0
 */

public interface ISkuStock {
    /**
     * 获取活动sku库存消耗队列
     *
     * @return 奖品库存Key信息
     * @throws InterruptedException 异常
     */
    ActivitySkuStockKeyVO takeQueueValue() throws InterruptedException;
    /**
     * 清空队列
     */
    void clearQueueValue();

    /**
     * 延迟队列 + 任务趋势更新活动sku库存
     *
     * @param sku 活动商品
     */
    void updateActivitySkuStock(Long sku);

    /**
     * 缓存库存以消耗完毕，清空数据库库存
     *
     * @param sku 活动商品
     */
    void clearActivitySkuStock(Long sku);
}
