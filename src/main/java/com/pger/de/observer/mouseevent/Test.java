package com.pger.de.observer.mouseevent;

import com.pger.de.observer.mouseevent.handler.Mouse;
import com.pger.de.observer.mouseevent.handler.MouseEventListener;
import com.pger.de.observer.mouseevent.handler.MouseEventType;

public class Test {
    public static void main(String[] args) {
        MouseEventListener listener = new MouseEventListener();

        Mouse mouse = new Mouse();

        mouse.addLisenter(MouseEventType.ON_CLICK, listener);
        mouse.addLisenter(MouseEventType.ON_MOVE, listener);

        mouse.click();
        mouse.move();

    }
}
