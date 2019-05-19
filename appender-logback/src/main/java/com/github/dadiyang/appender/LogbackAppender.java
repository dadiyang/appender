package com.github.dadiyang.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.ThrowableProxy;
import ch.qos.logback.core.AppenderBase;

/**
 * 自定义实现logback的输出源
 *
 * @author huangxuyang
 * @since 2019/4/30
 */
public class LogbackAppender extends AppenderBase<ILoggingEvent> {
    private String appName;

    @Override
    protected void append(ILoggingEvent event) {
        if (event == null || event.getMessage() == null) {
            return;
        }
        // 必须设置 appName
        if (appName == null || appName.isEmpty()) {
            return;
        }
        String level = event.getLevel().toString();
        String loggerName = event.getLoggerName();
        String msg = event.getFormattedMessage();
        String threadName = event.getThreadName();
        Throwable throwable = event.getThrowableProxy() != null ? ((ThrowableProxy) event.getThrowableProxy()).getThrowable() : null;
        System.out.println(appName + ": 自定义 logback appender, threadName: " + threadName + ", level: " + level + ", loggerName: " + loggerName + ", msg: " + msg);
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}