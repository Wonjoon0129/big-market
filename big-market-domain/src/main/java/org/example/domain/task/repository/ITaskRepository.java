package org.example.domain.task.repository;

import org.example.domain.task.model.entity.TaskEntity;

import java.util.List;

/**
 * @ClassName ITaskRepository
 * @Description 任务服务仓储接口
 * @Author @kimwonjoon
 * @Date 2025/2/24 23:45
 * @Version 1.0
 */

public interface ITaskRepository {
    List<TaskEntity> queryNoSendMessageTaskList();

    void sendMessage(TaskEntity taskEntity);


    void updateTaskSendMessageCompleted(String userId, String messageId);

    void updateTaskSendMessageFail(String userId, String messageId);
}
