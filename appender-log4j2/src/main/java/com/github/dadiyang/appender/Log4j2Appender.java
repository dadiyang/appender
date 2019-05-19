package com.github.dadiyang.appender;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;

/**
 * 自定义实现log4j2的输出源
 *
 * @author huangxuyang
 * @since 2019/4/30
 */
@Plugin(name = "Log4j2Appender", category = "Core", elementType = "appender", printObject = true)
public final class Log4j2Appender extends AbstractAppender {
    private String appName;

    protected Log4j2Appender(String name, String appName, Filter filter, Layout<? extends Serializable> layout,
                             final boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
        this.appName = appName;
    }

    @Override
    public void append(LogEvent event) {
        if (event == null || event.getMessage() == null) {
            return;
        }
        // 必须设置 appName
        if (appName == null || appName.isEmpty()) {
            return;
        }
        // 此处自定义实现输出
        String level = event.getLevel().toString();
        String loggerName = event.getLoggerName();
        String msg = event.getMessage().getFormattedMessage();
        String threadName = event.getThreadName();
        Throwable throwable = event.getThrown();
        System.out.println(appName + ": 自定义 log4j2 appender, threadName: " + threadName + ", level: " + level + ", loggerName: " + loggerName + ", msg: " + msg);
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }

    @PluginFactory
    public static Log4j2Appender createAppender(
            @PluginAttribute("name") String name,
            @PluginAttribute("appName") String appName,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginElement("Filter") final Filter filter) {
        if (name == null) {
            LOGGER.error("No name provided for Log4j2Appender");
            return null;
        }
        if (appName == null) {
            LOGGER.error("配置日志自定义 Appender 必须设置 appName 属性！！");
            return null;
        }
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new Log4j2Appender(name, appName, filter, layout, true);
    }

}