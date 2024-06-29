package org.nik.task_scheduler.entities;

import java.util.concurrent.TimeUnit;

public class Interval {
    private TimeUnit timeUnit;
    private long duration;

    public Interval(TimeUnit timeUnit, long duration) {
        this.timeUnit = timeUnit;
        this.duration = duration;
    }

    public long getDurationMillis() {
        switch (timeUnit) {
            case SECONDS: {
                return duration * 1000;
            }

            case MINUTES: {
                return duration * 60 * 1000;
            }
            case HOURS: {
                return duration * 60 * 60 * 1000;
            }

            default:
                throw new IllegalArgumentException("Unsupported time unit: " + timeUnit);
        }
    }
}
