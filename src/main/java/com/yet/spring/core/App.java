package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.beans.EventType;
import com.yet.spring.core.loggers.CacheFileEventLogger;
import com.yet.spring.core.loggers.ConsoleEventLogger;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


public class App {

    public App() {
    }

    private EventLogger eventLogger;
    private Client client;
    private Map<EventType, EventLogger> loggers;

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
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

        ctx.close();

    }


    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        super();
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(Event evt, String msg) {
                String message = msg.replaceAll(Integer.toString(client.getId()), client.getFullName());
                evt.setMsg(message);
                eventLogger.logEvent(evt);
    }

}
