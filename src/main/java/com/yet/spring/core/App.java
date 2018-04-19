package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.loggers.ConsoleEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

    public App() {
    }


    private ConsoleEventLogger eventLogger;
    private Client client;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        app.logEvent("Some event for 1 app");
        app.logEvent("Some event for 2 app");

//        App app = new App();
//        app.client = new Client(1, "John Smith");
//        app.eventLogger = new ConsoleEventLogger();
//
    }


    public App(Client client, ConsoleEventLogger eventLogger) {
        super();
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(
                Integer.toString(client.getId()), client.getFullName() );
                Event evt = new Event(message);
                eventLogger.logEvent(evt);
    }

}
