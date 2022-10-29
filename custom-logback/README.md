# SpringBoot集成logback异步日志存入自定义数据库

默认的表字段那么多，存储了很多内容，但是我们很多时候只是自己打印的日志内容，为了节省磁盘空间，这个时候可以自定义存储字段和存储内容

步骤：

### 1、创建数据库表

```mysql
DROP TABLE IF EXISTS `logging`;
CREATE TABLE `logging` (
 `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
 `message` VARCHAR(300) NOT NULL COMMENT '内容',
 `level_string` VARCHAR(254) NOT NULL COMMENT '级别',
 `created_time` DATETIME NOT NULL COMMENT '时间',
 `logger_name` VARCHAR(300) NOT NULL COMMENT '全类名',
 PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='自定义日志记录表'

```

### 2、重写DBAppender类为LogDBAppender类

```java
package com.me.study.springboot02mybatis.config;

import ch.qos.logback.classic.spi.CallerData;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.db.DBAppenderBase;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

@Configuration
public class LogDBAppender extends DBAppenderBase<ILoggingEvent> {

  protected static final Method GET_GENERATED_KEYS_METHOD;
  //插入sql
  protected String insertSQL;
  // message 日志内容
  static final int MESSAGE = 1;
  // level_string
  static final int LEVEL_STRING = 2;
  // created_time 时间
  static final int CREATE_TIME = 3;
  // logger_name 全类名
  static final int LOGGER_NAME = 4;

  static final StackTraceElement EMPTY_CALLER_DATA = CallerData.naInstance();

  static {
    // PreparedStatement.getGeneratedKeys() method was added in JDK 1.4
    Method getGeneratedKeysMethod;
    try {
      // the
      getGeneratedKeysMethod = PreparedStatement.class.getMethod("getGeneratedKeys", (Class[]) null);
    } catch (Exception ex) {
      getGeneratedKeysMethod = null;
    }
    GET_GENERATED_KEYS_METHOD = getGeneratedKeysMethod;
  }

  @Override
  public void start() {
    // 将写好的sql语句赋值给insertSQL
    insertSQL = buildInsertSQL();
    super.start();
  }

  // 自己写新增sql语句
  private static String buildInsertSQL() {
    return "INSERT INTO `logging`(`message`,`level_string`,`created_time`,`logger_name`)" +
        "VALUES (?,?,?,?)";
  }

  @Override
  protected Method getGeneratedKeysMethod() {
    return GET_GENERATED_KEYS_METHOD;
  }

  @Override
  protected String getInsertSQL() {
    return insertSQL;
  }

  /**
   * 主要修改的方法
   *
   * @param stmt
   * @param event
   * @throws SQLException
   */
  private void bindLoggingEventWithInsertStatement(PreparedStatement stmt, ILoggingEvent event) throws SQLException {
    // event.getFormattedMessage() 日志打印内容
    String message = event.getFormattedMessage();
    // 如果只想存储自己打印的日志，可以这样写日志：logger.info("- XXXX")
    if(message.startsWith("-")){ // 判断日志消息首字母为 - 的日志，记录到数据库表
      stmt.setString(MESSAGE, message);
      // event.getLevel().toString() 日志级别
      stmt.setString(LEVEL_STRING, event.getLevel().toString());
      // new Timestamp(event.getTimeStamp()) 时间
      stmt.setTimestamp(CREATE_TIME, new Timestamp(event.getTimeStamp()));
      // event.getLoggerName() 全类名
      stmt.setString(LOGGER_NAME, event.getLoggerName());
    }

  }

  @Override
  protected void subAppend(ILoggingEvent eventObject, Connection connection, PreparedStatement statement) throws Throwable {
    bindLoggingEventWithInsertStatement(statement, eventObject);
    // This is expensive... should we do it every time?
    int updateCount = statement.executeUpdate();
    if (updateCount != 1) {
      addWarn("Failed to insert loggingEvent");
    }
  }

  @Override
  protected void secondarySubAppend(ILoggingEvent eventObject, Connection connection, long eventId) throws Throwable {
  }
}
```

### 3、修改logback日志文件，引用自定义的LogDBAppender类

```xml
  <!--连接数据库配置-->
  <appender name="db_classic_mysql_pool" class="com.me.study.springboot02mybatis.config.LogDBAppender">
    <connectionSource class="ch.qos.logback.core.db.DataSourceConnectionSource">
      <dataSource class="org.apache.commons.dbcp.BasicDataSource">
        <driverClassName>com.mysql.cj.jdbc.Driver</driverClassName>
        <url>jdbc:mysql://127.0.0.1:3306/logdb?serverTimezone=Asia/Shanghai</url>
        <username>root</username>
        <password>admin</password>
      </dataSource>
    </connectionSource>
  </appender>

```

### 4、测试运行

#### 1）编写测试代码

```java
  @Test
  public void contextLoads() {
    logger.info("- 数据库日志info");
    logger.error("- 数据库日志error");
    logger.info("一条不带‘-'的日志，看会不会记录如数据库");
  }

```

#### 2)运行结果

![image-20221029182541238](D:\xm\docment\md\img\image-20221029182541238.png)

数据库存储结果只存储了自定义的日志记录