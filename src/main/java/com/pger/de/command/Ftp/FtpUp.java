package com.pger.de.command.Ftp;

public class FtpUp implements IFtpCommand {
    private FtpServerCommand command;

    public FtpUp(FtpServerCommand command) {
        this.command = command;
    }

    public void opt() {
        command.up();
    }
}
