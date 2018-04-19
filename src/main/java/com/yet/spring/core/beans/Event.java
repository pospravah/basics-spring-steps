package com.yet.spring.core.beans;

import java.util.Date;
import java.util.UUID;

public class Event {

    private int id;
    private String msg;
    private Date date;

    public Event(String msg) {
        this.msg = msg;
        this.id = msg.hashCode();
        this.date = new Date();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}
