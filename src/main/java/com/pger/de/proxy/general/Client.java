package com.pger.de.proxy.general;

/**
 *
 */
public class Client {

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();

    }

}
