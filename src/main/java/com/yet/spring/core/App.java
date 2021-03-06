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

        Event event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 1 app");

        event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 2 app");

        event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 3 app");

        event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 4 app");

        event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 5 app");

    }


    public App(Client client, ConsoleEventLogger eventLogger) {
        super();
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(Event evt, String msg) {
                String message = msg.replaceAll(Integer.toString(client.getId()), client.getFullName());
                evt.setMsg(message);
                eventLogger.logEvent(evt);
    }

}
