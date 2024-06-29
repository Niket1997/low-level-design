package org.nik.task_scheduler.interfaces;

import org.nik.task_scheduler.entities.Execution;
import org.nik.task_scheduler.records.CreateExecutionRequest;

// accessed by Task Service
public interface IExecutionService {
    Execution createExecution(CreateExecutionRequest execution);

    Execution getExecution(String id);

    void start();

    void stop();
}
