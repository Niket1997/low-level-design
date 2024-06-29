package org.nik.task_scheduler.entities;

import lombok.Data;
import org.nik.task_scheduler.enums.TaskStatus;
import org.nik.task_scheduler.interfaces.IExecutionContext;

import java.util.UUID;

@Data
public class Task {
    private String id;
    private IExecutionContext executionContext;
    private long startTimeMillis;
    private boolean isRecurring;
    private Interval schedule;
    private TaskStatus taskStatus;

    public Task(IExecutionContext executionContext, boolean isRecurring, Interval schedule, long startTimeMillis) {
        this.id = UUID.randomUUID().toString();
        this.executionContext = executionContext;
        this.startTimeMillis = startTimeMillis;
        this.isRecurring = isRecurring;
        this.schedule = schedule;
        this.taskStatus = TaskStatus.CREATED;
    }
}
