package com.pger.de.command.Ftp;

public class FptServerTest {
    public static void main(String[] args) {
        FtpServerCommand command = new FtpServerCommand();
        FtpController ftp = new FtpController();
        ftp.execCommand(new FtpStart(command));

        System.out.printf("===================\n");
        ftp.addCommand(new FtpConnnect(command));
        ftp.addCommand(new FtpCreateDir(command));
        ftp.execCommands();
    }
}
