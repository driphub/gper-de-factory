package com.pger.de.command.Ftp;

public class FtpCreateDir implements IFtpCommand {

    private FtpServerCommand command;

    public FtpCreateDir(FtpServerCommand command) {
        this.command = command;
    }

    public void opt() {
        command.createDir();
    }
}
