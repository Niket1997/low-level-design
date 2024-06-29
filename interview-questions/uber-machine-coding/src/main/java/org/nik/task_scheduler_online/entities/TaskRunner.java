package org.nik.task_scheduler_online.entities;

import org.nik.task_scheduler_online.interfaces.TaskStore;

import java.util.Optional;

public class TaskRunner implements Runnable {
    private final TaskStore taskStore;

    private volatile boolean isRunning;

    public TaskRunner(TaskStore taskStore) {
        this.taskStore = taskStore;
        this.isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning && !Thread.currentThread().isInterrupted()) {
            try {
                ScheduledTask task = taskStore.poll();
                long delay = task.getNextExecutionTime() - System.currentTimeMillis();
                if (delay > 0) {
                    taskStore.add(task);
                    synchronized (this) {
                        wait(delay);
                    }
                } else {
                    task.execute();
                    if (task.isRecurring()) {
                        Optional<ScheduledTask> nextOccurance = task.getNextScheduledTask();
                        nextOccurance.ifPresent(taskStore::add);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop() {
        isRunning = false;
        synchronized (this) {
            notify();
        }
    }
}
