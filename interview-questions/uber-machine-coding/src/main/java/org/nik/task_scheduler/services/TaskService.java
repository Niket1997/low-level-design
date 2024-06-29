package org.nik.task_scheduler.services;

import org.nik.task_scheduler.entities.Execution;
import org.nik.task_scheduler.entities.Task;
import org.nik.task_scheduler.interfaces.IExecutionService;
import org.nik.task_scheduler.interfaces.ITaskService;
import org.nik.task_scheduler.records.CreateExecutionRequest;
import org.nik.task_scheduler.records.CreateTaskRequest;
import org.nik.task_scheduler.repositories.TaskRepository;

import java.util.Optional;

public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;
    private final IExecutionService executionService;

    private static volatile TaskService instance;

    private TaskService() {
        taskRepository = TaskRepository.getInstance();
        executionService = ExecutionService.getInstance();
    }

    public static TaskService getInstance() {
        if (instance == null) {
            synchronized (TaskService.class) {
                if (instance == null) {
                    instance = new TaskService();
                }
            }
        }
        return instance;
    }

    @Override
    public Task submitTask(CreateTaskRequest request) {
        // create task
        Task task = new Task(request.getExecutionContext(), request.isRecurring(), request.getSchedule(), request.getStartTimeMillis());

        // create execution
        CreateExecutionRequest createExecutionRequest = new CreateExecutionRequest(task.getId(), task.getStartTimeMillis(), task.getExecutionContext());
        Execution execution = executionService.createExecution(createExecutionRequest);
        // save task
        taskRepository.save(task);
        return task;
    }

    @Override
    public Task getTask(String id) {
        return taskRepository.get(id);
    }

    @Override
    public void createNextExecutionIfApplicable(String id, long startTimeMillis) {
        synchronized (id) {
            Task task = taskRepository.get(id);

            if (!task.isRecurring()) return;

            long nextStartTime = startTimeMillis + task.getSchedule().getDurationMillis();

            CreateExecutionRequest createExecutionRequest = new CreateExecutionRequest(task.getId(), nextStartTime, task.getExecutionContext());
            Execution execution = executionService.createExecution(createExecutionRequest);
        }
    }
}
