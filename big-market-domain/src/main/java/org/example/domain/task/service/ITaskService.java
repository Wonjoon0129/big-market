package org.example.domain.task.service;

import org.example.domain.task.model.entity.TaskEntity;

import java.util.List;

/**
 * @ClassName ITaskService
 * @Description  消息任务服务接口
 * @Author @kimwonjoon
 * @Date 2025/2/24 23:41
 * @Version 1.0
 */

public interface ITaskService {
    /**
     * 查询发送MQ失败和超时1分钟未发送的MQ
     *
     * @return 未发送的任务消息列表10条
     */
    List<TaskEntity> queryNoSendMessageTaskList();

    void sendMessage(TaskEntity taskEntity);

    void updateTaskSendMessageCompleted(String userId, String messageId);

    void updateTaskSendMessageFail(String userId, String messageId);

}
