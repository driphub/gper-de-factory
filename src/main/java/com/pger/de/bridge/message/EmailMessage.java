package com.pger.de.bridge.message;

public class EmailMessage implements IMessage {
    public void send(String message, String toUser) {
        message = String.format("使用邮件消息发送 %s 给 %s ", message, toUser);
        System.out.printf(message);
    }
}
