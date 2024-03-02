# 分布式锁使用教程

## 启动服务![image-20221001210150916](../img/image-20221001210150916.png)

访问[localhost:5004/redisson/test](http://localhost:5004/redisson/test)接口

![image-20221001212316020](D:\xm\docment\md\img\image-20221001212316020.png)

模拟并发不加锁情况，可以看到，两个线程同时抢夺一个资源，并且都成功了，出现了超卖情况。

```java
2022-10-01 21:04:36.820  INFO 24620 --- [      Thread-21] c.f.r.controller.RedissonLockController  : count值：6
2022-10-01 21:04:36.820  INFO 24620 --- [      Thread-23] c.f.r.controller.RedissonLockController  : count值：6
2022-10-01 21:04:36.820  INFO 24620 --- [      Thread-28] c.f.r.controller.RedissonLockController  : count值：7
2022-10-01 21:04:36.820  INFO 24620 --- [      Thread-22] c.f.r.controller.RedissonLockController  : count值：7
2022-10-01 21:04:36.820  INFO 24620 --- [      Thread-24] c.f.r.controller.RedissonLockController  : count值：5
2022-10-01 21:04:36.820  INFO 24620 --- [      Thread-25] c.f.r.controller.RedissonLockController  : count值：4
2022-10-01 21:04:36.820  INFO 24620 --- [      Thread-26] c.f.r.controller.RedissonLockController  : count值：3
2022-10-01 21:04:36.821  INFO 24620 --- [      Thread-27] c.f.r.controller.RedissonLockController  : count值：2
2022-10-01 21:04:36.822  INFO 24620 --- [      Thread-29] c.f.r.controller.RedissonLockController  : count值：1
2022-10-01 21:04:36.822  INFO 24620 --- [      Thread-30] c.f.r.controller.RedissonLockController  : count值：0
```

模拟并发加锁情况，可以看到每卖一件商品，数值减一。

```java
2022-10-01 21:04:36.838  INFO 24620 --- [      Thread-29] c.f.r.controller.RedissonLockController  : lockCount值：9
2022-10-01 21:04:36.876  INFO 24620 --- [      Thread-22] c.f.r.controller.RedissonLockController  : lockCount值：8
2022-10-01 21:04:36.887  INFO 24620 --- [      Thread-28] c.f.r.controller.RedissonLockController  : lockCount值：7
2022-10-01 21:04:36.906  INFO 24620 --- [      Thread-24] c.f.r.controller.RedissonLockController  : lockCount值：6
2022-10-01 21:04:36.920  INFO 24620 --- [      Thread-26] c.f.r.controller.RedissonLockController  : lockCount值：5
2022-10-01 21:04:36.938  INFO 24620 --- [      Thread-25] c.f.r.controller.RedissonLockController  : lockCount值：4
2022-10-01 21:04:36.986  INFO 24620 --- [      Thread-30] c.f.r.controller.RedissonLockController  : lockCount值：3
2022-10-01 21:04:37.012  INFO 24620 --- [      Thread-27] c.f.r.controller.RedissonLockController  : lockCount值：2
2022-10-01 21:04:37.057  INFO 24620 --- [      Thread-21] c.f.r.controller.RedissonLockController  : lockCount值：1
2022-10-01 21:04:37.107  INFO 24620 --- [      Thread-23] c.f.r.controller.RedissonLockController  : lockCount值：0
```

