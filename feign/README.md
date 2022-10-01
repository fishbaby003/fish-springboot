# 如何单独使用feign

## 1、启动其他服务，以redis项目示例

![image-20221001210150916](../img/image-20221001210150916.png)

访问[localhost:5004/hello](http://localhost:5004/hello)

![image-20221001210400257](../img/image-20221001210400257.png)

## 2、启动本服务

![image-20221001210708060](../img/image-20221001210708060.png)

```java
UserService URL改成上面项目
```

![image-20221001210844907](../img/image-20221001210844907.png)

访问[localhost:8080/hello](http://localhost:8080/hello)，调用成功！

![image-20221001210903735](../img/image-20221001210903735.png)