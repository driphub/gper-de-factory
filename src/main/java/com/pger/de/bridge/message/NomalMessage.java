package com.pger.de.bridge.message;

public class NomalMessage extends AbstractMessage {
    public NomalMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        super.sendMessage(message, toUser);
    }
}
