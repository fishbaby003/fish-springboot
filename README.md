
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
    - [SpringBoot集成logback异步日志](logback/README.md)
    
    使用springboot、logback技术
    - [SpringBoot集成分布式存储minio](minio/README.md)
    
    使用springboot、mybatis、mysql、minio、knife4j技术
    - [SpringBoot集成mongodb](mongodb/README.md)
    
    使用springboot、mongodb、smart-doc技术
    - [SpringBoot集成MyBatis](mybatis/README.md)
    
     使用springboot、mybatis、mysql、logging技术
    - [SpringBoot集成分布式锁redis](redis/README.md)
    
     使用springboot、redis分布式锁技术
    - [SpringBoot集成sharding-jdbc](sharding-jdbc/README.md)
    
     使用springboot、mybatis、mysql、logging、sharding-jdbc分布式锁技术
     
    - ~~SpringBoot集成JPA~~