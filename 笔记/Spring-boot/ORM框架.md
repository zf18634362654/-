**ORM框架**

![image-20191110092204518](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191110092204518.png)

Spring DATA JPA 是 Hibernate 的规范







**集成Mybatis**

@mapper注解会很麻烦，这时可以使用@MapperScan注解来扫描包。

经测试发现，@MapperScan注解只会扫描包中的接口，不会扫描类，所以可以在包中写Provider类。

@MapperScan("com.demo.mapper")：扫描指定包中的接口

@MapperScan("com.demo.*.mapper")：一个*代表任意字符串，但只代表一级包,比如可以扫到com.demo.aaa.mapper,不能扫到com.demo.aaa.bbb.mapper

@MapperScan("com.demo.**.mapper")：两个*代表任意个包,比如可以扫到com.demo.aaa.mapper,也可以扫到com.demo.aaa.bbb.mapper



1   复杂SQL  交给XML  便于维护

2   简单SQL  注解搞定

![image-20191111183714183](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191111183714183.png)

3  分页插件 PageHelper

```java
PageHelper.startPage(1,2);
PageInfo<People>  page=PageInfo.of(new ArrayList<People>());
```

 https://www.cnblogs.com/viyoung/p/10534910.html
https://blog.csdn.net/zhaoyanjun6/article/details/80696898 