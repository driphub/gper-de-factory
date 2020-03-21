package com.pger.de.mediator.chatroom;

public class ServerChatMediator extends ChatMediator {

    @Override
    public void send2ChatRoom(User user, String msg) {
        this.room.showMsg(user, msg);
    }
}
