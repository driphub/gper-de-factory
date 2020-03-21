package com.pger.de.mediator.chatroom;

public abstract class ChatMediator {
    protected ChatRoom room;

    public void setChatRoom(ChatRoom room) {
        this.room = room;
    }

    public abstract void send2ChatRoom(User user, String msg);

}
