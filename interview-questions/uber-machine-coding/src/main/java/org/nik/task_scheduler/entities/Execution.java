package org.nik.task_scheduler.entities;

import lombok.Data;
import org.nik.task_scheduler.enums.ExecutionStatus;
import org.nik.task_scheduler.interfaces.IExecutionContext;

import java.util.UUID;

@Data
public class Execution {
    private String id;
    private String taskId;
    private IExecutionContext executionContext;
    private long startTimeMillis;
    private ExecutionStatus status;
    private long createdAtMillis;
    private long pickedAtMillis;
    private long completedAtMillis;
    private long failedAtMillis;

    public Execution(String taskId, long startTimeMillis, IExecutionContext executionContext) {
        this.id = UUID.randomUUID().toString();
        this.executionContext = executionContext;
        this.taskId = taskId;
        this.startTimeMillis = startTimeMillis;
        this.status = ExecutionStatus.PICKED;
        this.createdAtMillis = System.currentTimeMillis();
    }
}
