package com.github.dadiyang.appender;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackAppenderTest {
    private static final Logger log = LoggerFactory.getLogger(LogbackAppenderTest.class);

    @Test
    public void test() {
        log.debug("{} OK", "logback");
        log.info("{} OK", "logback");
        log.warn("Not OK", "logback");
        log.error("logback ERROR OCCUR!", new IllegalStateException("xxx"));
    }
}