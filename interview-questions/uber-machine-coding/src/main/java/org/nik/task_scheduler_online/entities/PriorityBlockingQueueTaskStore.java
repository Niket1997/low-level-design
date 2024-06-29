package org.nik.task_scheduler_online.entities;

import org.nik.task_scheduler_online.interfaces.TaskStore;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTaskStore implements TaskStore {
    private final PriorityBlockingQueue<ScheduledTask> queue;
    private final Set<ScheduledTask> tasks;

    public PriorityBlockingQueueTaskStore(Comparator<ScheduledTask> comparator, int capacity) {
        this.queue = new PriorityBlockingQueue<>(capacity, comparator);
        this.tasks = new HashSet<>();
    }

    @Override
    public ScheduledTask peek() {
        return queue.peek();
    }

    @Override
    public ScheduledTask poll() {
        return queue.poll();
    }

    @Override
    public void add(ScheduledTask task) {
        if (tasks.contains(task)) {
            return;
        }
        tasks.add(task);
        queue.add(task);
    }

    @Override
    public boolean remove(ScheduledTask task) {
        if (tasks.contains(task)) {
            tasks.remove(task);
            queue.remove(task);
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
