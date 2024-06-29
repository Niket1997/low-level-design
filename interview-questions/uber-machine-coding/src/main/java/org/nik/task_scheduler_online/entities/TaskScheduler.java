package org.nik.task_scheduler_online.entities;

import org.nik.task_scheduler_online.interfaces.TaskStore;

import java.util.ArrayList;
import java.util.List;

public class TaskScheduler {
    private final List<Thread> threads;

    private final List<TaskRunner> taskRunners;

    private final TaskStore taskStore;

    public TaskScheduler(ExecutorConfig executorConfig, TaskStore taskStore) {
        this.threads = new ArrayList<>();
        this.taskRunners = new ArrayList<>();
        this.taskStore = taskStore;
        for (int i = 0; i < executorConfig.getNumThreads(); i++) {
            TaskRunner taskRunner = new TaskRunner(taskStore);
            Thread thread = new Thread(taskRunner);
            thread.start();
            threads.add(thread);
            taskRunners.add(taskRunner);
        }
    }

    public void stop() {
        taskRunners.forEach(TaskRunner::stop);
        threads.forEach(t -> {
            t.interrupt();
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

    }
}
