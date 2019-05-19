package com.github.dadiyang.appender;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jAppenderTest {
    private static final Logger log = LoggerFactory.getLogger(Log4jAppenderTest.class);

    @Test
    public void testLog() {
        log.debug("{} debug OK", "log4j");
        log.info("{} OK", "log4j");
        log.warn("Not OK", "log4j");
        log.error("log4j ERROR OCCUR!", new IllegalStateException("xxx"));
    }
}