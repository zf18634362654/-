**Maven集成Tomcat**

1

![image-20191109155555118](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191109155555118.png)

```xml
<plugins>    
     
	  <!-- tomcat插件控制 -->
		<plugin>
		    <groupId>org.apache.tomcat.maven</groupId>
		    <artifactId>tomcat7-maven-plugin</artifactId>
		    <version>2.2</version>
		    <configuration>              
				<port>8080</port>              
				<path>/</path>          
				<uriEncoding>UTF-8</uriEncoding>
			</configuration>
		</plugin>
	  <!-- maven插件控制 -->
	  		<plugin>
	  			<groupId>org.apache.maven.plugins</groupId>
	  			<artifactId>maven-compiler-plugin</artifactId>
	  			<version>3.1</version>
	  			<configuration>
	  				<source>1.8</source>
	  				<target>1.8</target>
	  				<encoding>utf-8</encoding>
	  			</configuration>
	  		</plugin>            
		</plugins>
	
```

2

直接配置Tomcat运行