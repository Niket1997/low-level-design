package org.nik.task_scheduler.records;

import lombok.Data;
import org.nik.task_scheduler.entities.Interval;
import org.nik.task_scheduler.interfaces.IExecutionContext;

@Data
public class CreateTaskRequest {
    private IExecutionContext executionContext;
    private long startTimeMillis;
    private boolean isRecurring;
    private Interval schedule;

    public CreateTaskRequest(IExecutionContext executionContext, long startTimeMillis, boolean isRecurring, Interval schedule) {
        this.executionContext = executionContext;
        this.startTimeMillis = startTimeMillis;
        this.isRecurring = isRecurring;
        this.schedule = schedule;
    }
}
