package com.pger.de.mediator.chatroom;

public class Test {

    public static void main(String[] args) {
        ServerChatMediator mediator = new ServerChatMediator();
        ChatRoom room = new ChatRoom(mediator);

        User jj = new User("JJ", mediator);
        User kk = new User("KK", mediator);

        jj.sendMessage("hi i am jj");
        kk.sendMessage("hello my nam is kk");
    }
}
