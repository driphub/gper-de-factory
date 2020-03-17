package com.pger.de.command.Ftp;

public class FtpStart implements IFtpCommand {

    private FtpServerCommand ftpServerCommand;

    public FtpStart(FtpServerCommand command) {
        this.ftpServerCommand = command;
    }

    public void opt() {
        ftpServerCommand.start();
    }

}
