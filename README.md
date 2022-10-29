
## 介绍

**fish-springboot** 一个以 `springboot` 为基础开发框架，
整合 `Redis` 、`mybatis` 、`jpa` 、`Mysql` 、`postgresql` 、`oracle` 、 `Rabbitmq` 、 `RocketMQ` 、`ES` 、`MongoDB`、`sharding-jdbc
分库分表`、`nacos` 、`knife4j`、`smart-doc` 、`cas` 等互联网主流技术，
文章图解理论配合实战案例，实现开发中常见功能点的综合项目。
本着拿来即用的原则，助力于减少开发者在工作中的学习成本。

中间件 | 已整合的功能
-------- | -----
分库分表 | sharding-jdbc、mycat
缓存  | Redis
数据库  | Mysql、postgresql、Oracle
消息队列  | Rabbitmq 、kafka、RocketMQ
搜索引擎  | ES
非关系数据库  | MongoDB
注册中心  | nacos
存储  | minio
消息推送  | 7种实时消息推送
更多 | ......


> Springboot demos 持续更新中... @fish

- Springboot demos
    - [SpringBoot集成logback异步日志并存入自定义数据库](custom-logback/README.md)
    
    使用springboot、logback技术，支持db2、h2、hsqldb、mssql、mysql、oracle、postgresql、sqllite、sybasesqlAnywhere
    - [SpringBoot集成elasticsearch](elasticsearch/README.md)
    
    使用springboot、jpa、mysql、elasticsearch技术
    - [SpringBoot单独集成feign](feign/README.md)
    
    使用springboot、feign技术
    
    视频教程：[springboot单独使用feign@DOU+小助手 - java相关技术 - 西瓜视频 (ixigua.com)](https://www.ixigua.com/7032850126301463077?utm_source=xiguastudio)
    
    [springboot单独使用feign_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1u34y1o71Y/)
    
    - [SpringBoot集成logback异步日志](logback/README.md)
    
    使用springboot、logback技术
    - [SpringBoot集成分布式存储minio](minio/README.md)
    
    使用springboot、mybatis、mysql、minio、knife4j技术
    
    视频教程：[springboot集成minio分布式文件存储_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1fa411P7ku/)
    
    [Docker安装分布式对象存储服务库Minio_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1ua411f7jH/?vd_source=3bda6fc772b7ed16c92b952131636c82)
    
    [springboot集成minio分布式文件存储 - java相关技术 - 西瓜视频 (ixigua.com)](https://www.ixigua.com/7130975482731987493)
    
    [Docker安装分布式对象存储服务库Minio - docker技术 - 西瓜视频 (ixigua.com)](https://www.ixigua.com/7128023882229809694)
    
    - [SpringBoot集成mongodb](mongodb/README.md)
    
    使用springboot、mongodb、smart-doc技术
    
    视频教程：[springboot集成mongodb并进行增删改查操作-初级篇 - java相关技术 - 西瓜视频 (ixigua.com)](https://www.ixigua.com/7139900087308091941)
    
    [springboot集成mongodb并进行增删改查操作-初级篇_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV18t4y177PA/)
    
    - [SpringBoot集成MyBatis](mybatis/README.md) 
    
     使用springboot、mybatis、mysql、logging技术
    
    视频教程：[Mybatis动态生成临时表并引用 - java相关技术 - 西瓜视频 (ixigua.com)](https://www.ixigua.com/7079422194211947038))
    
    [不使用第三方分页插件，springboot集成mybatis自定义分页 - java相关技术 - 西瓜视频 (ixigua.com)](https://www.ixigua.com/7136909729883750925?utm_source=xiguastudio)
    
    [Mybatis动态生成临时表并引用_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1h3411p7Lb/?vd_source=3bda6fc772b7ed16c92b952131636c82)
    
    [不使用第三方分页插件，springboot集成mybatis自定义分页_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1S14y1x7fd/)
    
    - [SpringBoot集成分布式锁redis](redis/README.md)
    
     使用springboot、redis分布式锁技术
    
    视频教程：[springboot集成redisson实现分布式锁@DOU+小助手 - java相关技术 - 西瓜视频 (ixigua.com)](https://www.ixigua.com/7030401908795769380?utm_source=xiguastudio)
    
    [springboot集成redisson实现分布式锁_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1Rr4y1r7tN/)
    
    - [SpringBoot集成sharding-jdbc](sharding-jdbc/README.md)
    
     使用springboot、mybatis、mysql、logging、sharding-jdbc分布式锁技术
    
    视频教程：[SpringBoot集成Sharding-JDBC不分库只分表模式 - java相关技术 - 西瓜视频 (ixigua.com)](https://www.ixigua.com/7147309450733453838?utm_source=xiguastudio)
    
    [SpringBoot集成Sharding-JDBC不分库只分表模式_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1id4y1z7St/)
    
    - ~~SpringBoot集成JPA~~