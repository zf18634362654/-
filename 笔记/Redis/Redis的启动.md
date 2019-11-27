Redis的启动

启动redis服务.

```
$ cd src
$ ./redis-server
```



注意这种方式启动redis 使用的是默认配置。也可以通过启动参数告诉redis使用指定配置文件使用下面命令启动。

```
$ cd src
$ ./redis-server ../redis.conf
```

**redis.conf** 是一个默认的配置文件。我们可以根据需要使用自己的配置文件。

启动redis服务进程后，就可以使用测试客户端程序redis-cli和redis服务交互了。 比如：

```
$ cd src
$ ./redis-cli
redis> set foo bar
OK
redis> get foo
"bar"
```

```java
import redis.clients.jedis.Jedis;

public class TestRedis {
public static void main(String[] args) {
	  //连接本地的 Redis 服务
    Jedis jedis = new Jedis("192.168.2.128",6379);
    
    System.out.println("连接成功");
    
    //查看服务是否运行
    jedis.select(0);
    String color=jedis.get("color1");
    System.out.println(color);
    System.out.println("服务正在运行: "+jedis.ping());
}
	//如果连接成功  返回PONG

}
```

