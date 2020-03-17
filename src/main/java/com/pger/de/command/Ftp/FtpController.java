package com.pger.de.command.Ftp;

import java.util.ArrayList;
import java.util.List;

public class FtpController {
    private List<IFtpCommand> commandList = new ArrayList<IFtpCommand>();

    public void addCommand(IFtpCommand ftpCommand) {
        commandList.add(ftpCommand);
    }

    public void execCommand(IFtpCommand ftpCommand) {
        ftpCommand.opt();
    }

    public void execCommands() {
        if (commandList !=null && !commandList.isEmpty()) {
            for (IFtpCommand ftpCommand : commandList) {
                ftpCommand.opt();
            }
            commandList.clear();
        }
    }

}
