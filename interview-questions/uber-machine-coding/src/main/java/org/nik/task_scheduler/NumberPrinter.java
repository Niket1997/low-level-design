package org.nik.task_scheduler;

import org.nik.task_scheduler.interfaces.IExecutionContext;

public class NumberPrinter implements IExecutionContext {
    @Override
    public void execute() {
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
