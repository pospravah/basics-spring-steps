package com.yet.spring.core.loggers;

public class ConsoleEventLogger implements EventLogger {

    public void logEvent(String message) {
        System.out.println("Log message: " +message);
    }
}
