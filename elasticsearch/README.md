# springboot集成elasticSearch（带权限密码）两种配置方式

#### 1、引入spring-boot-starter-data-elasticsearch包

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
</dependency>
```

#### 2、添加es配置

不同的版本的配置方法不太一致。这里我呈现两个版本的配置方式

![image-20211216155039753](https://img-blog.csdnimg.cn/img_convert/46841bcfce9492c360a0ac4f8ae019ad.png)

##### 4.30版本

方法一、yml文件添加

```yml
spring:
  elasticsearch:
    uris: ["127.0.0.1:9200"]
    username: "elastic"
    password: "yuyuyu"
```

方法二、便携config文件

```java
package com.example.esdemo;

import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.config.AbstractReactiveElasticsearchConfiguration;
import org.springframework.http.HttpHeaders;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ReactiveRestClientConfig extends AbstractElasticsearchConfiguration {
    private String host = "127.0.0.1";
    private Integer port = 9200;
    private String userName = "elastic";
    private String password = "yuyuyu";

    @Override
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .withBasicAuth(userName,password)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
```

如果是带密码的最好再yml配置下忽略将康检测。否则启动会报错（无伤大雅，非强迫症可以不理）。

```yml
// 去除es数据库健康检查
management:
  health:
    elasticsearch:
      enabled: false
```

###### 4.01版本

![image-20211216155433394](https://img-blog.csdnimg.cn/img_convert/983ec95569180e80280ae787d45f61da.png)

方法一、配置yml文件

```yml
spring:  
  elasticsearch:
    rest:
      uris: [ "127.0.0.1:9200" ]
      username: "elastic"
      password: "yuyuyu"
```

方法二、便携config文件

```java
package com.example.esdemo;

        import lombok.extern.log4j.Log4j2;
        import org.apache.http.HttpHost;
        import org.apache.http.auth.AuthScope;
        import org.apache.http.auth.UsernamePasswordCredentials;
        import org.apache.http.client.CredentialsProvider;
        import org.apache.http.impl.client.BasicCredentialsProvider;
        import org.elasticsearch.client.RequestOptions;
        import org.elasticsearch.client.RestClient;
        import org.elasticsearch.client.RestClientBuilder;
        import org.elasticsearch.client.RestHighLevelClient;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.data.elasticsearch.client.ClientConfiguration;
        import org.springframework.data.elasticsearch.client.RestClients;
        import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
        import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
        import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
        import org.springframework.data.elasticsearch.config.AbstractReactiveElasticsearchConfiguration;
        import org.springframework.http.HttpHeaders;

        import java.time.Duration;
        import java.time.LocalDateTime;
        import java.time.format.DateTimeFormatter;

@Configuration
public class ReactiveRestClientConfig extends AbstractElasticsearchConfiguration {
    private String host = "127.0.0.1";
    private Integer port = 9200;
    private String userName = "elastic";
    private String password = "yuyuyu";

    @Override
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .withBasicAuth(userName,password)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
```

如果是带密码的最好再yml配置下忽略将康检测。否则启动会报错（无伤大雅，非强迫症可以不理）。

```yml
// 去除es数据库健康检查
management:
  health:
    elasticsearch:
      enabled: false
```

###### 

之后有其他版本都根据下图自己摸索配置方法

![image-20211216155655438](https://img-blog.csdnimg.cn/img_convert/92dec3baf32be07eba9bb0eede6b0bb1.png)