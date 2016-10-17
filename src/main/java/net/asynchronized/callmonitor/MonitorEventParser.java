/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.asynchronized.callmonitor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enrico
 */
public class MonitorEventParser {

    public static MonitorEvent parse(String message) {
        MonitorEvent event = null;

        String[] messageParts = message.split(";");
        if (messageParts.length > 1) {
            switch (messageParts[1]) {
                case CallEvent.EVENT_NAME:
                    event = parseCallEvent(messageParts);
                    break;
                case ConnectEvent.EVENT_NAME:
                    event = parseConnectEvent(messageParts);
                    break;
                case DisconnectEvent.EVENT_NAME:
                    event = parseDisconnectEvent(messageParts);
                    break;
                case RingEvent.EVENT_NAME:
                    event = parseRingEvent(messageParts);
                    break;
                default:
                    event = new MonitorEvent();
                    event.setEvent("UNKNOWN");
                    event.setTime(parseDate(messageParts[0]));
                    break;
            }
        }

        return event;
    }

    private static CallEvent parseCallEvent(String[] messageParts) {
        CallEvent event = new CallEvent();
        event.setTime(parseDate(messageParts[0]));
        event.setConnectionId(messageParts[2]);
        event.setSubstation(messageParts[3]);
        event.setSourceNumber(messageParts[4]);
        event.setTargetNumber(messageParts[5]);
        event.setProtocol(messageParts[6]);
        
        return event;
    }

    private static ConnectEvent parseConnectEvent(String[] messageParts) {
        ConnectEvent event = new ConnectEvent();
        event.setTime(parseDate(messageParts[0]));
        event.setConnectionId(messageParts[2]);
        event.setSubstation(messageParts[3]);
        event.setNumber(messageParts[4]);

        return event;
    }

    private static DisconnectEvent parseDisconnectEvent(String[] messageParts) {
        DisconnectEvent event = new DisconnectEvent();
        event.setTime(parseDate(messageParts[0]));
        event.setConnectionId(messageParts[2]);
        event.setDuration(messageParts[3]);

        return event;
    }

    private static RingEvent parseRingEvent(String[] messageParts) {
        RingEvent event = new RingEvent();
        event.setTime(parseDate(messageParts[0]));
        event.setConnectionId(messageParts[2]);
        event.setCallingNumber(messageParts[3]);
        event.setTargetNumber(messageParts[4]);
        event.setProtocol(messageParts[5]);

        return event;
    }
    
    private static Date parseDate(String s) {
        DateFormat format = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        Date date = null;
        
        try {
            date = format.parse(s);
        } catch (ParseException ex) {
            Logger.getLogger(MonitorEventParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
}
