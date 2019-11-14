**IDEA插件以及快捷键**  **热部署**

1 lombok插件是为了方便实体类bean快速生成get set方法,从而不用手动添加

```xml
<dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.16.10</version>
        <scope>provided</scope>
    </dependency>
```

 @Data注解在类上，会为类的所有属性自动生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法 

 @Getter/@Setter注解，此注解在属性上，可以为相应的属性自动生成Getter/Setter方法 

 @ToString注解，Lombok会生成一个toString()方法 

@Slf4j    直接用log.info();   不用再声明

类似

```java
Logger log = LoggerFactory.getLogger(this.getClass());
```

 @Builder声明实体，表示可以进行Builder方式初始化，@Value注解，表示只公开getter，对所有属性的setter都封闭，即private修饰，所以它不能和@Builder现起用

@Builder注解赋值新对象

```java
UserInfo userInfo = UserInfo.builder()
        .name("zzl")
        .email("bgood@sina.com")
        .build();
```

@Builder注解修改原对象的属性值

修改实体，要求实体上添加@Builder(toBuilder=true)

```java
 userInfo = userInfo.toBuilder()
        .name("OK")
        .email("zgood@sina.com")
        .build();
```

 People people= People.builder().build();

2

**Spring Boot热部署** 

第一步

```xml
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            
 </dependency>
```

第二步

```xml
<build>
		<plugins>
			<plugin>
				<configuration>
					<fork>true</fork>
				</configuration>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build><plugn>
 <configuration>
			<fork>true</fork>
 </configuration>
</plugn>	
```

第三步

<img src="C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108155736197.png" alt="image-20191108155736197" style="zoom:50%;" />

打开自动编译

第四步  CTRL +SHIFT +ALT+/  注册

![image-20191108155905136](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108155905136.png)

3

GsonFormat插件  将JSON数据转换为JavaBean类型

![image-20191108162125327](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108162125327.png)

4

Maven Helper

![image-20191108162103579](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108162103579.png)