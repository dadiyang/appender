package com.github.dadiyang.appender;


import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * @author huangxuyang
 * @since 2019/4/30
 */
public class Log4jAppender extends AppenderSkeleton {
    private String appName;

    @Override
    protected void append(LoggingEvent event) {
        if (event == null || event.getMessage() == null) {
            return;
        }
        // 必须设置 appName
        if (appName == null || appName.isEmpty()) {
            return;
        }
        String level = event.getLevel().toString();
        String loggerName = event.getLoggerName();
        String msg = event.getRenderedMessage();
        String threadName = event.getThreadName();
        Throwable throwable = event.getThrowableInformation() != null ? event.getThrowableInformation().getThrowable() : null;
        System.out.println(appName + ": 自定义 log4j appender, threadName: " + threadName + ", level: " + level + ", loggerName: " + loggerName + ", msg: " + msg);
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}