Protobuf(Google Protocol Buffer)是Google公司开发的一种跨语言和平台的序列化数据结构的方式，是一个灵活的、高效的用于序列化数据的协议。

protobuf是跨语言的，并且自带一个编译器(protoc)，只需要用protoc进行编译，就可以编译成Java、Python、C++、C#、Go等多种语言代码，然后可以直接使用，不需要再写其它代码，自带有解析的代码。

对于结构中的每个成员会提供set系列函数和get系列函数。

protobuf的优点：

　　性能好/效率高，序列化和反序列化的时间开销都很小。

　　与XML和JSON格式相比，protobuf更小、更快、更便捷。

　　扩展性好，兼容性好。

　　支持多种语言。

protobuf的不足：

　　采用**二进制编码**，可读性差。

　　缺乏自描述，**二进制的协议内容必须配合.proto文件的定义才有含义**。

protoc.exe 下载： https://github.com/protocolbuffers/protobuf/releases

#### **1、添加protobuf文件ProtoDemo.proto**

```java
syntax = "proto3";

option java_package = "com.fish.protobuf.entity";

option java_outer_classname = "ProtoDemo";

message Student {
     int32 id = 1;
     string name = 2;
     string email = 3;

    enum Sex {
        MAN = 0;
        WOMAN = 1;
    }
     Sex sex = 4 ;

    enum PhoneType{
        MOBILE = 0;
        HOME = 1;
        WORK = 2;
    }

    message PhoneNumber {
         string number = 1;
         PhoneType type = 2 ;
    }

    repeated PhoneNumber phone = 5;
}
```

#### **2、使用protoc.exe生成java文件**

```protobuf
protoc.exe --java_out=. ProtoDemo.proto
```

#### **3、将生成的MessageUser.java放到对应的位置，如com\\fish\\protobuf\entity**

#### **4、添加依赖**

```xml
<dependency>
       <groupId>com.google.protobuf</groupId>
       <artifactId>protobuf-java</artifactId>
       <version>3.11.4</version>
</dependency>
<dependency>
<groupId>com.googlecode.protobuf-java-format</groupId>
        <artifactId>protobuf-java-format</artifactId>
        <version>1.4</version>
</dependency>
```

#### **5、测试**

创建一个Test类进行测试.代码如下

```java
package com.fish.protobuf.proto.com.fish.protobuf;
 
import com.fish.protobuf.entity.ProtoDemo;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
 
import java.util.List;
 
/**
 * @author fish
 */
public class Test {
    public static void main(String[] args) {
        //获取Student对象
        //这里的Student对象构造器被私有化,我们通过Student的内部类Builder来构建builder
        ProtoDemo.Student.Builder builder= ProtoDemo.Student.newBuilder();
        //通过Student的内部类builder提供了构建Student相关属性的set方法
        builder.setId(1);
        builder.setName("凌晨0点0分");
        builder.setEmail("31346337@qq.com");
        builder.setSex(ProtoDemo.Student.Sex.MAN);
        //获取PhoneNumber对象
        ProtoDemo.Student.PhoneNumber.Builder builder1=ProtoDemo.Student.PhoneNumber.newBuilder();
        builder1.setNumber("13657177663");
        builder1.setType(ProtoDemo.Student.PhoneType.MOBILE);
        ProtoDemo.Student.PhoneNumber pn=builder1.build();
        builder.addPhone(pn);
        //再创建1个PhoneNumber对象
        pn=ProtoDemo.Student.PhoneNumber.newBuilder()
                .setNumber("13581491939").setType(ProtoDemo.Student.PhoneType.HOME).build();
        builder.addPhone(pn);
        //序列化
        ProtoDemo.Student stu=builder.build();
        System.out.println("protobuf数据大小: " + stu.toByteString().size());
        //再将封装有数据的对象实例，转换为字节数组，用于数据传输、存储等
        byte[] stuByte = stu.toByteArray();
        //这里得到了stuBte字节数组后，我们可以将该数据进行数据传输或存储，这里至于用什么技术传输就根据具体情况而定
        //假如这里stuByt通过传输，下面的代码接到了该数据
        //接收方 ,这里为了方便我们就写在一个类里面
        //将字节数据反序列化为对应的对象实例
        ProtoDemo.Student student=null;
        try {
             student= ProtoDemo.Student.parseFrom(stuByte);
            //这里得到了Student实例了，就可以根据需要来操作里面的数据了
            System.out.println("学生ID:"+student.getId());
            System.out.println("姓名："+student.getName());
            System.out.println("性别："+(student.getSex().getNumber()==0?"男":"女"));
            System.out.println("邮箱："+student.getEmail());
            //遍历phoneNumber字段
            List<ProtoDemo.Student.PhoneNumber> phList = student.getPhoneList();
            for (ProtoDemo.Student.PhoneNumber p : phList) {
                System.out.println(p.getType()+"电话:"+p.getNumber());
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        /*如何快速的进行json格式化*/
        String jsonObject="";
        try {
            jsonObject= JsonFormat.printer().print(student);
        } catch (InvalidProtocolBufferException e) {
            e.getMessage();
        }
        System.out.println(jsonObject.toString());
        System.out.println("json数据大小: "+jsonObject.getBytes().length);
    }
}
```

