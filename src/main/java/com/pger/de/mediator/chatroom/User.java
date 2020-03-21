package com.pger.de.mediator.chatroom;

public class User {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String msg) {
        this.mediator.send2ChatRoom(this, msg);
    }

}
