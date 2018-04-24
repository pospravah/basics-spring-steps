package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.beans.EventType;
import com.yet.spring.core.loggers.CacheFileEventLogger;
import com.yet.spring.core.loggers.ConsoleEventLogger;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {

    public App() {
    }

    private EventLogger defaultLogger;

    private Client client;

    private Map<EventType, EventLogger> loggers;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for 1 app");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for 2 app");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR,event, "Some event for 3 app");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for 4 app");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR , event, "Some event for 5 app");

        ctx.close();

    }


    public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggers;
    }

    private void logEvent(EventType eventType, Event evt, String msg) {
                String message = msg.replaceAll(Integer.toString(client.getId()), client.getFullName());
                evt.setMsg(message);

                EventLogger logger = loggers.get(eventType);
                if (logger == null) {
                    logger = defaultLogger;

                }
            logger.logEvent(evt);
    }

}
