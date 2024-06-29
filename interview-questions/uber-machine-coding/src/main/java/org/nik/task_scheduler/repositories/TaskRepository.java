package org.nik.task_scheduler.repositories;

import org.nik.task_scheduler.entities.Task;
import org.nik.task_scheduler.exception.TaskNotFoundException;

import java.util.HashMap;

public class TaskRepository {
    private HashMap<String, Task> tasks;

    private static volatile TaskRepository instance;

    private TaskRepository() {
        tasks = new HashMap<>();
    }

    public static TaskRepository getInstance() {
        if (instance == null) {
            synchronized (TaskRepository.class) {
                if (instance == null) {
                    instance = new TaskRepository();
                }
            }
        }
        return instance;
    }

    public void save(Task task) {
        tasks.put(task.getId(), task);
    }

    public Task get(String id) {
        if (!tasks.containsKey(id)) {
            throw new TaskNotFoundException("Task with id " + id + " not found");
        }
        return tasks.get(id);
    }
}
