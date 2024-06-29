package org.nik.task_scheduler_online.entities;

import org.nik.task_scheduler_online.interfaces.ExecutionContext;

import java.util.Optional;

public abstract class ScheduledTask {
    public final ExecutionContext context;

    public ScheduledTask(ExecutionContext context) {
        this.context = context;
    }

    abstract boolean isRecurring();

    void execute() {
        context.execute();
    }

    abstract Optional<ScheduledTask> getNextScheduledTask();

    abstract long getNextExecutionTime();
}
