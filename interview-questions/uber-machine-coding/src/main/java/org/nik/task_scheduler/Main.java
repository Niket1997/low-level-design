package org.nik.task_scheduler;

import org.nik.task_scheduler.entities.Interval;
import org.nik.task_scheduler.interfaces.IExecutionContext;
import org.nik.task_scheduler.interfaces.IExecutionService;
import org.nik.task_scheduler.interfaces.ITaskService;
import org.nik.task_scheduler.records.CreateTaskRequest;
import org.nik.task_scheduler.services.ExecutionService;
import org.nik.task_scheduler.services.TaskService;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        IExecutionService executionService = ExecutionService.getInstance();
        ITaskService taskService = TaskService.getInstance();

        IExecutionContext numberPrinter = new NumberPrinter();
        long startTimeMillis = System.currentTimeMillis() + 2000;
        Interval schedule = new Interval(TimeUnit.SECONDS, 5);
        CreateTaskRequest createTaskRequest = new CreateTaskRequest(
                numberPrinter,
                startTimeMillis,
                true,
                schedule
        );
        taskService.submitTask(createTaskRequest);
        System.out.println("starting execution\n");
        executionService.start();

        Thread.sleep(10000);
        executionService.stop();
        System.out.println("\nstopping execution\n");
    }
}
