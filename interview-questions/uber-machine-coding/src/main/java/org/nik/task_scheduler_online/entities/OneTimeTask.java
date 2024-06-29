package org.nik.task_scheduler_online.entities;

import org.nik.task_scheduler_online.interfaces.ExecutionContext;

import java.util.Optional;

public class OneTimeTask extends ScheduledTask {
    private final long executionTime;

    public OneTimeTask(ExecutionContext context, long executionTime) {
        super(context);
        this.executionTime = executionTime;
    }

    @Override
    boolean isRecurring() {
        return false;
    }

    @Override
    Optional<ScheduledTask> getNextScheduledTask() {
        return Optional.empty();
    }

    @Override
    long getNextExecutionTime() {
        return executionTime;
    }
}
