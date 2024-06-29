package org.nik.task_scheduler.services;

import org.nik.task_scheduler.constants.ExecutionConstants;
import org.nik.task_scheduler.entities.Execution;
import org.nik.task_scheduler.interfaces.IExecutionService;
import org.nik.task_scheduler.records.CreateExecutionRequest;
import org.nik.task_scheduler.repositories.ExecutionRepository;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutionService implements IExecutionService {
    private final ExecutionRepository executionRepository;

    private static volatile ExecutionService instance;

    private final ThreadPoolExecutor threadPoolExecutor;

    private ExecutionService() {
        executionRepository = ExecutionRepository.getInstance();
        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(ExecutionConstants.THREAD_COUNT);
    }

    public static ExecutionService getInstance() {
        if (instance == null) {
            synchronized (ExecutionService.class) {
                if (instance == null) {
                    instance = new ExecutionService();
                }
            }
        }
        return instance;
    }

    @Override
    public Execution createExecution(CreateExecutionRequest request) {
        Execution execution = new Execution(request.getTaskId(), request.getStartTimeMillis(), request.getExecutionContext());

        // save to repository
        executionRepository.save(execution);
        return execution;
    }

    @Override
    public Execution getExecution(String id) {
        return executionRepository.getExecution(id);
    }

    @Override
    public void start() {
        for (int i = 0; i < ExecutionConstants.THREAD_COUNT; i++) {
            ExecutionRunner executionRunner = new ExecutionRunner();
            threadPoolExecutor.execute(executionRunner);
        }
    }

    @Override
    public void stop() {
        threadPoolExecutor.shutdownNow();
    }
}
