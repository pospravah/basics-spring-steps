package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;

public class ConsoleEventLogger implements EventLogger {

//  public void logEvent(String message) {
//      System.out.println("Log message: " +message);
//  }

    public void logEvent(Event event) {
        System.out.println("Log message: " +event.toString());
    }
}
