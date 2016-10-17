/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.asynchronized.callmonitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enrico
 */
public class CallMonitor extends Thread {

    private List<CallMonitorListener> listeners = new ArrayList<>();
    
    private String host;
    private int port;
    private Socket socket;
    private boolean shutdown = false;

    public CallMonitor(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public CallMonitor() {
        this("fritz.box", 1012);
    }
    
    public void addCallMonitorListener(CallMonitorListener listener) {
        listeners.add(listener);
        start();
    }
    
    public void removeCallMonitorListener(CallMonitorListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void run() {
        try {
            socket = new Socket(host, port);
            System.out.println("connected to " + host + ":" + port);
            while (socket.isConnected()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String s = br.readLine();
                handleEvent(s);
            }
        } catch (Exception ex) {
            if (!shutdown) {
                Logger.getLogger(CallMonitor.class.getName()).log(Level.SEVERE, "Failed to connect to " + host + ":" + port, ex);
            }
        }
    }
    
    

    public void stopMonitor() {
        try {
            shutdown = true;
            interrupt();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(CallMonitor.class.getName()).log(Level.SEVERE, "Failed to stop CallMonitor", ex);
        }
    }

    private void handleEvent(String s) {
        if (s != null && !s.isEmpty()) {
            MonitorEvent event = MonitorEventParser.parse(s);

            if (event instanceof CallEvent) {
                CallEvent call = (CallEvent) event;
                fireCallEvent(call);
            } else if (event instanceof ConnectEvent) {
                ConnectEvent connect = (ConnectEvent) event;
                fireConnectEvent(connect);
            } else if (event instanceof DisconnectEvent) {
                DisconnectEvent disconnect = (DisconnectEvent) event;
                fireDisconnectEvent(disconnect);
            } else if (event instanceof RingEvent) {
                RingEvent call = (RingEvent) event;
                fireRingEvent(call);
            }

        }
    }
    
    private void fireCallEvent(CallEvent evt) {
        Iterator i = listeners.iterator();
        while (i.hasNext()) {
            ((CallMonitorListener) i.next()).onCall(evt);
        }
    }
    
    private void fireConnectEvent(ConnectEvent evt) {
        Iterator i = listeners.iterator();
        while (i.hasNext()) {
            ((CallMonitorListener) i.next()).onConnect(evt);
        }
    }
    
    private void fireDisconnectEvent(DisconnectEvent evt) {
        Iterator i = listeners.iterator();
        while (i.hasNext()) {
            ((CallMonitorListener) i.next()).onDisconnect(evt);
        }
    }
    
    private void fireRingEvent(RingEvent evt) {
        Iterator i = listeners.iterator();
        while (i.hasNext()) {
            ((CallMonitorListener) i.next()).onRing(evt);
        }
    }
}
