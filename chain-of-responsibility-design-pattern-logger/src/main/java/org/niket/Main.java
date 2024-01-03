package org.niket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(LogProcessor.INFO, "Info message");
        logProcessor.log(LogProcessor.DEBUG, "Debug message");
        logProcessor.log(LogProcessor.ERROR, "Error Message");
        logProcessor.log(LogProcessor.INFO, "New Info message");
        System.out.println("awesome");
    }
}