package org.nik.task_scheduler.records;

import lombok.Data;
import org.nik.task_scheduler.interfaces.IExecutionContext;

@Data
public class CreateExecutionRequest {
    private String taskId;
    private long startTimeMillis;
    private IExecutionContext executionContext;

    public CreateExecutionRequest(String taskId, long startTimeMillis, IExecutionContext executionContext) {
        this.taskId = taskId;
        this.startTimeMillis = startTimeMillis;
        this.executionContext = executionContext;
    }
}
