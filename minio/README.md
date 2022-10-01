# springboot集成分布式存储minio

#### docker安装minio

拉取minio镜像

```shell
docker pull minio/minio
```

运行容器

```shell
docker run -p 9000:9000 -p 9090:9090 --name minio  -e "MINIO_ACCESS_KEY=admin"  -e "MINIO_SECRET_KEY=admin"  -v /home/data:/data  -v /home/config:/root/.minio minio/minio server /data --console-address ":9000" --address ":9090"
```

API: http://172.17.0.2:9090  http://127.0.0.1:9090 

Console: http://172.17.0.2:9000 http://127.0.0.1:9000 

Documentation: https://docs.min.io

###### 存储桶命名规则

以下规则适用于命名 S3 存储桶：

-   存储桶名称必须长在 3 到 63 个字符之间。
-   存储桶名称只能由小写字母、数字、点 （.） 和连字符 （-） 组成。
-   存储桶名称必须以字母或数字开头和结尾。
-   存储桶名称不得格式化为 IP 地址（例如，192.168.5.4）。
-   存储桶名称在分区中必须是唯一的。分区是区域的分组。AWS 目前有三个分区：（标准区域）、（中国区域）和（AWS GovCloud \[美国\]区域）。awsaws-cnaws-us-gov
-   与 Amazon S3 传输加速一起使用的存储桶的名称中不能有点 （.）。有关传输加速的详细信息，请参阅亚马逊S3 传输加速。