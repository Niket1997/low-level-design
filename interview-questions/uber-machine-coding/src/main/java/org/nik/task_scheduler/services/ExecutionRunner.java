package org.nik.task_scheduler.services;

import org.nik.task_scheduler.entities.Execution;
import org.nik.task_scheduler.interfaces.ITaskService;
import org.nik.task_scheduler.repositories.ExecutionRepository;

public class ExecutionRunner implements Runnable {
    private final ExecutionRepository executionRepository;
    private final ITaskService taskService;

    public ExecutionRunner() {
        this.executionRepository = ExecutionRepository.getInstance();
        this.taskService = TaskService.getInstance();
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Execution execution = null;
            try {
                execution = executionRepository.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                continue;
            }
            long delay = execution.getStartTimeMillis() - System.currentTimeMillis();
            if (delay > 0) {
                executionRepository.offer(execution);
                continue;
            }
            execution.getExecutionContext().execute();
            taskService.createNextExecutionIfApplicable(execution.getTaskId(), execution.getStartTimeMillis());
        }
        System.out.println("Thread interrupted");
    }
}
