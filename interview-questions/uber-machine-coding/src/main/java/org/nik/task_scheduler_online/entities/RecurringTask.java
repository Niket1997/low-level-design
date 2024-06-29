package org.nik.task_scheduler_online.entities;

import org.nik.task_scheduler_online.interfaces.ExecutionContext;

import java.util.Optional;

public class RecurringTask extends ScheduledTask {
    private final long executionTime;
    private final long interval;

    public RecurringTask(ExecutionContext context, long executionTime, long interval) {
        super(context);
        this.executionTime = executionTime;
        this.interval = interval;
    }

    @Override
    boolean isRecurring() {
        return true;
    }

    @Override
    Optional<ScheduledTask> getNextScheduledTask() {
        return Optional.of(new RecurringTask(context, executionTime + interval, interval));
    }

    @Override
    long getNextExecutionTime() {
        return executionTime;
    }
}
