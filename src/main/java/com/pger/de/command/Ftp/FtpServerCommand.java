package com.pger.de.command.Ftp;

public class FtpServerCommand {
    public void start() {
        System.out.printf("启动服务");
    }

    public void connect() {
        System.out.printf("连接服务器");
    }

    public void up() {
        System.out.printf("上传");
    }

    public void download() {
        System.out.printf("下载");
    }

    public void createDir() {
        System.out.printf("创建文件夹");
    }

}
