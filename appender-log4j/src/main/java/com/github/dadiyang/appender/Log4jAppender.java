package com.github.dadiyang.appender;


import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * @author dadiyang
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
        // todo 这里实现自定义的日志处理逻辑
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

    /**
     * 定义 setter 方法，这样在配置文件中添加类似 log4j.appender.CustomAppender.appName=test_app_name 的配置项时，配置会被注入到这个 appender 中
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }
}