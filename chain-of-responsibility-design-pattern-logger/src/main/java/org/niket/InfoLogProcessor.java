package org.niket;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message) {
        if (logLevel == INFO) {
            System.out.println("INFO: " + message);
        } else {
            System.out.println("Passing to DEBUG Log Processor");
            super.log(logLevel, message);
        }
    }
}
