package com.pger.de.bridge.message;

public class UrgencyMessage extends AbstractMessage {

    public UrgencyMessage(IMessage message) {
        super(message);
    }

    public void sendMessage(String message, String toUser) {
        message = String.format("[加急消息]：%s", message);
        super.sendMessage(message + "\n", toUser);
    }

    public Object watch(String messageId) {
        return null;
    }


}
