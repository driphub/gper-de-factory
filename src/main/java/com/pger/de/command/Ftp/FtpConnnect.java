package com.pger.de.command.Ftp;

public class FtpConnnect implements IFtpCommand {
    private FtpServerCommand command;

    public FtpConnnect(FtpServerCommand command) {
        this.command = command;
    }

    public void opt() {
        command.connect();
    }

}
