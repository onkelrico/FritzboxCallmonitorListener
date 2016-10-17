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
public class RingEvent extends MonitorEvent {
    public static final String EVENT_NAME = "RING";
    private String callingNumber;
    private String targetNumber;
    private String protocol;

    public RingEvent() {
        super(EVENT_NAME);
    }

    public String getCallingNumber() {
        return callingNumber;
    }

    public void setCallingNumber(String callingNumber) {
        this.callingNumber = callingNumber;
    }

    public String getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(String targetNumber) {
        this.targetNumber = targetNumber;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public String toString() {
        return "RingEvent{" + super.toString() + ", callingNumber=" + callingNumber + ", targetNumber=" + targetNumber + ", protocol=" + protocol + '}';
    }
}
