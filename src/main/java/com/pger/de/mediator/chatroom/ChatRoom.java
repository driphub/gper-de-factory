package com.pger.de.mediator.chatroom;

public class ChatRoom {
    private ChatMediator mediator;

    public  ChatRoom(ChatMediator mediator) {
        this.mediator = mediator;
        this.mediator.setChatRoom(this);
    }

    public void showMsg(User user, String msg) {
        System.out.println("[" + user.getName() + "] :" + msg);
    }

}
