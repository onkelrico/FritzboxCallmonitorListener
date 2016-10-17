/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.asynchronized.callmonitor;

/**
 *
 * @author enrico
 */
public class DisconnectEvent extends MonitorEvent {
    public static final String EVENT_NAME = "DISCONNECT";

    private String duration;
    
    public DisconnectEvent() {
        super(EVENT_NAME);
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "DisconnectEvent{" + super.toString() + ", duration=" + duration + '}';
    }
    
}
