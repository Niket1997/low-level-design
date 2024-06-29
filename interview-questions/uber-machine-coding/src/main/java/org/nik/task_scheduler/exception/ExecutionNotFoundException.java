package org.nik.task_scheduler.exception;

public class ExecutionNotFoundException extends RuntimeException {
    public ExecutionNotFoundException(String message) {
        super(message);
    }
}
