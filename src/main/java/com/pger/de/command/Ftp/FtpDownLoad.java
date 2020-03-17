package com.pger.de.command.Ftp;

public class FtpDownLoad implements IFtpCommand {

    private FtpServerCommand command;

    public FtpDownLoad(FtpServerCommand command) {
        this.command = command;
    }

    public void opt() {
        command.download();
    }
}
