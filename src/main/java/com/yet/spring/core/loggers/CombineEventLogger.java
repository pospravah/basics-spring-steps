package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;

public class CombineEventLogger implements EventLogger {

    String event;
    FileEventLogger flog = new FileEventLogger(event);
    ConsoleEventLogger clog = new ConsoleEventLogger(event);
    private String filename;

    public void logEvent(Event event) {

    }
}
