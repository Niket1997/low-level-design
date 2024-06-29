package org.nik.task_scheduler.repositories;

import lombok.Getter;
import org.nik.task_scheduler.constants.ExecutionConstants;
import org.nik.task_scheduler.entities.Execution;
import org.nik.task_scheduler.exception.ExecutionNotFoundException;

import java.util.HashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutionRepository {
    private HashMap<String, Execution> executions;
    private PriorityBlockingQueue<Execution> executionQueue;

    @Getter
    private String lockKey;

    private static volatile ExecutionRepository instance;

    private ExecutionRepository() {
        executions = new HashMap<>();
        executionQueue = new PriorityBlockingQueue<>(ExecutionConstants.QUEUE_SIZE, (a, b) -> Math.toIntExact(a.getStartTimeMillis() - b.getStartTimeMillis()));
        lockKey = "LOCK_KEY";
    }

    public static ExecutionRepository getInstance() {
        if (instance == null) {
            synchronized (ExecutionRepository.class) {
                if (instance == null) {
                    instance = new ExecutionRepository();
                }
            }
        }
        return instance;
    }

    public Execution getExecution(String id) {
        if (!executions.containsKey(id)) {
            throw new ExecutionNotFoundException("Execution with id " + id + " not found");
        }
        return executions.get(id);
    }

    public void save(Execution execution) {
        executionQueue.add(execution);
        executions.put(execution.getId(), execution);
    }

    public Execution peek() {
        return executionQueue.peek();
    }

    public Execution take() throws InterruptedException {
        return executionQueue.take();
    }

    public void offer(Execution execution) {
        executionQueue.offer(execution);
    }

    public boolean isEmpty() {
        return executionQueue.isEmpty();
    }
}
