package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.loggers.ConsoleEventLogger;

public class App {

    private Client client;
    private ConsoleEventLogger eventLogger;

    public static void main(String[] args) {

        App app = new App();

        app.client = new Client(1, "John Smith");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent("Some event from user 1 app");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(
                Integer.toString(client.getId()), client.getFullName() );
                eventLogger.logEvent(message);
    }
}
