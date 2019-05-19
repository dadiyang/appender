package com.github.dadiyang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2AppenderTest {
    private static final Logger log = LoggerFactory.getLogger(Log4j2AppenderTest.class);

    @Test
    public void test() {
        log.debug("{} debug OK", "log4j2");
        log.info("{} OK", "log4j2");
        log.warn("Not OK", "log4j2");
        log.error("log4j2 ERROR OCCUR!", new IllegalStateException("xxx"));
    }

}