package com.pger.de.bridge.message;

public class DingdingMessage implements IMessage {
    public void send(String message, String toUser) {
        message = String.format("使用钉钉发送消息 %s 给 %s ", message, toUser);
        System.out.printf(message);
    }
}
