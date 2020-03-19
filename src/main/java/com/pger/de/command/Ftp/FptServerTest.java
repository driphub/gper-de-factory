package com.pger.de.command.Ftp;

import org.openjdk.jol.info.ClassLayout;

public class FptServerTest {
    public static void main(String[] args) {
//        FtpServerCommand command = new FtpServerCommand();
//        FtpController ftp = new FtpController();
//        ftp.execCommand(new FtpStart(command));
//
//        System.out.printf("===================\n");
//        ftp.addCommand(new FtpConnnect(command));
//        ftp.addCommand(new FtpCreateDir(command));
//        ftp.execCommands();

        Object o = new Object();

        //o.hashCode();

        System.out.printf(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            System.out.printf(ClassLayout.parseInstance(o).toPrintable());
        }

    }

//    public class Test {
//        private static volatile int i = 0;
//        public static void n() {
//            i++;
//        }
//        public static synchronized void m() {
//
//        }
//
//        public static void main(String[] args) {
//            for (i = 0; j < 1000; j++) {
//                m();
//                n();
//            }
//        }
//    }

}