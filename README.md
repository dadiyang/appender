# 自定义日志 appender 

    自定义的 log4j、log4j2 和 logback 等日志框架的 Appender 示例

# 项目

根据不同的日志框架，选择相应的 appender

* [appender-log4j](./appender-log4j)
* [appender-log4j2](./appender-log4j2)
* [appender-logback](./appender-logback)

# 配置文件示例：

## logback.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration scan="true" debug="false">
    <appender name="CustomAppender" class="com.github.dadiyang.appender.LogbackAppender">
        <!-- 这里填写集群名称 -->
        <appName>test_logback_appender_app</appName>
    </appender>
    <root level="INFO">
        <appender-ref ref="CustomAppender"/>
    </root>
</configuration>
```

## log4j2.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<configuration status="WARN">
    <appenders>
        <!-- 这个就是自定义的Appender -->
        <Log4j2Appender name="CustomAppender" appName="test_logback_appender_app"/>
    </appenders>
    <loggers>
        <root level="INFO">
            <!-- 注册到全局 appender -->
            <appender-ref ref="CustomAppender"/>
        </root>
    </loggers>
</configuration>
```

## log4j.properties

```properties
# 全局使用
log4j.rootLogger=INFO,CustomAppender
# 或者指定包或 logger 
log4j.logger.com.bj58...=DEBUG,CustomAppender
# 注册 Log4jAppender 
log4j.appender.CustomAppender=com.github.dadiyang.appender.Log4jAppender
# 这里填写集群名称
log4j.appender.CustomAppender.appName=test_logback_appender_app
```