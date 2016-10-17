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
public interface CallMonitorListener {
    
    public void onCall(CallEvent evt);
    
    public void onConnect(ConnectEvent evt);
    
    public void onDisconnect(DisconnectEvent evt);
    
    public void onRing(RingEvent evt);
    
}
