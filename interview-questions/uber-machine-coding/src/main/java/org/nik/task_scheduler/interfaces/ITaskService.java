package org.nik.task_scheduler.interfaces;

import org.nik.task_scheduler.entities.Execution;
import org.nik.task_scheduler.entities.Task;
import org.nik.task_scheduler.records.CreateTaskRequest;

import java.util.Optional;

public interface ITaskService {
    Task submitTask(CreateTaskRequest request);

    Task getTask(String id);

    void createNextExecutionIfApplicable(String id, long startTimeMillis);
}
