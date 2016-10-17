package net.asynchronized.callmonitor;

public class MonitorDemo implements CallMonitorListener {

    private CallMonitor monitor;
    
    public MonitorDemo() {
        monitor = new CallMonitor();
        monitor.addCallMonitorListener(this);
    }
    
    
    
    public static void main(String[] args) {
        MonitorDemo t = new MonitorDemo();
        
    }

    @Override
    public void onCall(CallEvent evt) {
        System.out.println(evt);
    }

    @Override
    public void onConnect(ConnectEvent evt) {
        System.out.println(evt);
    }

    @Override
    public void onDisconnect(DisconnectEvent evt) {
        System.out.println(evt);
    }

    @Override
    public void onRing(RingEvent evt) {
        System.out.println(evt);
    }

}