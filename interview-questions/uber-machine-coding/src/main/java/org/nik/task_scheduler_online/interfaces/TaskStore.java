package org.nik.task_scheduler_online.interfaces;

import org.nik.task_scheduler_online.entities.ScheduledTask;

public interface TaskStore {
    ScheduledTask peek();

    ScheduledTask poll();

    void add(ScheduledTask task);

    boolean remove(ScheduledTask task);

    boolean isEmpty();
}
