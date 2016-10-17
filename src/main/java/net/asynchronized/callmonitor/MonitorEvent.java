/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.asynchronized.callmonitor;

import java.util.Date;

/**
 *
 * @author enrico
 */
public class MonitorEvent {
    private Date time;
    private String event;
    private String connectionId;

    public MonitorEvent() {
    }

    public MonitorEvent(String event) {
        this.event = event;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    @Override
    public String toString() {
        return "MonitorEvent{" + "time=" + time + ", event=" + event + ", connectionId=" + connectionId + '}';
    }
    
    
}
