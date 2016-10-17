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
public class CallEvent extends MonitorEvent {
    public static final String EVENT_NAME = "CALL";
    
    private String substation;
    private String sourceNumber;
    private String targetNumber;
    private String protocol;

    public CallEvent() {
        super(EVENT_NAME);
    }

    public String getSubstation() {
        return substation;
    }

    public void setSubstation(String substation) {
        this.substation = substation;
    }

    public String getSourceNumber() {
        return sourceNumber;
    }

    public void setSourceNumber(String sourceNumber) {
        this.sourceNumber = sourceNumber;
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
        return "CallEvent{" + super.toString() + ", substation=" + substation + ", sourceNumber=" + sourceNumber + ", targetNumber=" + targetNumber + ", protocol=" + protocol + '}';
    }
    
    
}
