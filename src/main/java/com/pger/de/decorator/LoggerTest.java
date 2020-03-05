package com.pger.de.decorator;

import org.slf4j.Logger;

public class LoggerTest {
    private static final Logger log = JsonLoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        log.info("------ 系统信息");
    }

}
