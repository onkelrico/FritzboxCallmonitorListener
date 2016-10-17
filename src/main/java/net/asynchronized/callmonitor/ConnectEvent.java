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
public class ConnectEvent extends MonitorEvent {
    public static final String EVENT_NAME = "CONNECT";

    private String substation;
    private String number;
    
    public ConnectEvent() {
        super(EVENT_NAME);
    }

    public String getSubstation() {
        return substation;
    }

    public void setSubstation(String substation) {
        this.substation = substation;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ConnectEvent{" + super.toString() + ", substation=" + substation + ", number=" + number + '}';
    }
    
    
}
