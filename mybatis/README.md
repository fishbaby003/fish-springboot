# Mybatis开启控制台打印sql语句的三种方式

## **springboot+mybatis整合过程中，开启控制台sql语句打印的多种方式：**

**附：[mybatis官方文档](https://mybatis.org/mybatis-3/zh/logging.html "mybatis官方文档")**

### **方法一：**

**1>（spring+mybatis）在mybatis的配置文件中添加：**

```xml
<settings>
    <!-- 打印sql日志 -->
    <setting name="logImpl" value="STDOUT_LOGGING" />
</settings>
```

**mybatis的配置文件----mybatis-config.xml如下：**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>
        <!-- 打印sql日志 -->
        <setting name="logImpl" value="STDOUT_LOGGING" />
    </settings>
</configuration>
```

**2> (springboot+mybatis)在springboot的配置文件----appcation.yml中添加：**

```yaml
mybatis:
    configuration:
      log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

**ps：**

          **IDEA中，springboot默认配置文件是application.properties文件，但是yml文件在语法上更加简洁，更有层次感，所以此处是用yml语法，properties中好像是这么写的：mybatis.configuration.log-impl= org.apache.ibatis.logging.stdout.StdOutImpl**

**控制台可以打印了。。。。。**

![image-20220918203520338](../../../img/image-20220918203520338.png)

### **方法二：**

**在springboot+mybatis整合中，可以将springboot的配置文件添加如下一段也可：**

```yaml
logging:
  level:
    com.fish.mybatis.mapper: debug
```



![image-20220918203959784](../../../img/image-20220918203959784.png)

![image-20220918203454223](../../../img/image-20220918203454223.png)

**其中com.fish.mybatis.mapper是包名**

### **方法三：**

**如果你使用的是springboot+mybatis-plus的话：**

```xml
  <dependency>
       <groupId>com.baomidou</groupId>
       <artifactId>mybatis-plus-boot-starter</artifactId>
       <version>3.3.1</version>
  </dependency>
```

**application.yml:** 

```yaml
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

**控制台打印：** 

```java
JDBC Connection [HikariProxyConnection@1006460161 wrapping com.mysql.cj.jdbc.ConnectionImpl@37cccae8] will not be managed by Spring
==>  Preparing: select * from t_user where id = ?
==> Parameters: 1(Integer)
<==    Columns: id, user_name, age
<==        Row: 1, 张三, 18
<==      Total: 1
```
