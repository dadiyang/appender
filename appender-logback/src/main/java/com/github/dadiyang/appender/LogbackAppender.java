package com.github.dadiyang.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.ThrowableProxy;
import ch.qos.logback.core.AppenderBase;

/**
 * 自定义实现logback的输出源
 *
 * @author dadiyang
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
        // todo 这里实现自定义的日志处理逻辑
        System.out.println(appName + ": 自定义 logback appender, threadName: " + threadName + ", level: " + level + ", loggerName: " + loggerName + ", msg: " + msg);
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }

    /**
     * 定义 setter 方法，这样配置项会被注入到这个 appender 中
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }
}