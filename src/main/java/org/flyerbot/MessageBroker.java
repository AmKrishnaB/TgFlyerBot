package org.flyerbot;

public class MessageBroker {
    public static String[] application(String userMsg){
        String[] msg=userMsg.substring(9).trim().split("-");
        return msg;
    }
}
