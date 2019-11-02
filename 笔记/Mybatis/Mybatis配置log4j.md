**Mybatis配置log4j**



**1**配置日志

```xmlx
 <settings>
  <setting name="logImpl" value="LOG4J"/>
  </settings>
```





**2**日志文件

log4j.rootLogger=DEBUG, stdout //控制台输出
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n



**注解配置**

![image-20191101132055504](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191101132055504.png)