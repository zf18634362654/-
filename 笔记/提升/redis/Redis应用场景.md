# Redis应用场景

![image-20200429142939132](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429142939132.png)



## String结构应用场景

![image-20200429143149974](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429143149974.png)



![image-20200429144234876](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429144234876.png)

![image-20200429144436524](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429144436524.png)







## List应用场景



![image-20200429144850789](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429144850789.png)

## Hash应用场景

![image-20200429145558334](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429145558334.png)

![image-20200429150109714](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429150109714.png)

**==                  哈希结构 存储对象 方便扩充              ==            **





![image-20200429150320780](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429150320780.png)



![image-20200429150852287](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429150852287.png)



![image-20200429150928555](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429150928555.png)





## Set应用场景

![image-20200429151720778](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429151720778.png)

![image-20200429152204591](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429152204591.png)

## ZSet应用场景

![image-20200429152715674](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429152715674.png)

# 应用举例

## 1.点赞











## 2.缓存



### 2.1缓存穿透问题（缓存中，数据库中根本没有）

解决方法：

​         **1.缓存空对象**

​       为了防止数据一致被null频闭了，我们给所有数据加上过期时间，某个时间后允许去数据库查新数据

​        优点：简单

​         缺点：会有大量的空对象在内存中，治标不治本

​          **2.布隆过滤器**

​         第一种            谷歌提供了一个框架（单机版的）而且用的是JVM内存

​          第二种     自定义   （用的reidis缓存）分布式  利用Redis底层是位数组保存，借用String类型可以将其成为散列的数组

**布隆过滤器原理**

![image-20200429133621749](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429133621749.png)



![image-20200429131817037](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200429131817037.png)





### 2.2缓存击穿（缓存中没有，数据库中有）

并发问题（缓存中没有，很多人对这条缓存中没有的数据去请求数据库）



解决方法：1.分布式项目加入分布式锁







### 2.3缓存雪崩



![image-20200527211845266](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200527211845266.png)







# 两种压力测试工具

Apache ab

Apache jmeter

[两者的区别]( https://www.cnblogs.com/baby123/p/12047273.html )







# 高并发加锁问题



## 1.不加锁   单个服务（请求10000次后 num值不是10000）

```python
public   void inc(){
        redisTemplate.opsForValue().increment("num");
    }
```





## 2.加锁 单个服务  （请求10000次后  num值是10000）

```java
public synchronized inc(){
        redisTemplate.opsForValue().increment("num");
    }
```



## 3.加锁  服务集群(例如同一个服务启动三份)(请求10000次后 num值小于10000)   nginx 端口分发实现负载均衡

```java
public synchronized inc(){
        redisTemplate.opsForValue().increment("num");
    }
```

原因：

**synchronized是针对自己的服务，而不作用于分布式**（分布式系统JVM都是各自的）



## 4.使用redis加锁

第一阶段

```java
public void hello(){
String lock = redisTemplate.opsForValue().get("lock");
if(lock == null){
redisTemplate.opsForValue().set("lock","123");
    
//执行业务
xxxx
    
//执行业务完成后释放锁
redisTemplate.delete("lock");

    return;
}

else{
//重试  自旋锁
while(true){
hello();
}
}


}
```



由于第一阶段的get（“lock”）和set获取锁的操作不是原子性的 

改为使用Redis中的setnx()    这个操作是原子性的  如果不存在key，则可以新建锁 



第二阶段

```java
public void hello(){

//1.获取到锁
Integer lock =     redisTemplate.opsForValue().setIfAbsent("lock","123");
if(lock!=0){

//执行业务
xxxx
    
//执行业务完成后释放锁
redisTemplate.delete("lock");
return ;
}
else{
//重试  自旋锁
while(true){
hello();
}

}




}
```



第二阶段会暴露问题，万一获取锁后服务崩掉，那就会永久持有锁，其他服务得不到锁，造成死锁，设置key的过期时间并保证其原子性





第三阶段

```java
public void hello(){

//1.获取到锁  并且设置过期时间
 redisTemplate.opsForValue().setIfAbsent("lock","123",10L, TimeUnit.SECONDS);
if(lock!=0){

//执行业务
xxxx
    
//执行业务完成后释放锁
redisTemplate.delete("lock");
return ;
}
else{
//重试  自旋锁
while(true){
hello();
}

}




}
```





第三阶段暴露的问题 （服务可能没有执行完毕，锁就过期了，然后业务执行完成后又删除自己的锁，此时有两个线程进去的代码块）

第四阶段

```java
public void hello(){
String token = UUID;
Integer result = redisTemplate.opsForValue().setIfAbsent("lock","123",10L, TimeUnit.SECONDS);

if(result!=0){
//执行业务

//删除锁，保证删除的是自己的锁
if(redisTemplate.opsForValue().get("lock")== token){
   //如果token和当初存的值
   redisTemplate.delete("lock");
}
}


else{
//重试  自旋锁
while(true){
hello();
}

}


}

```



第四阶段暴露的问题  加入我们在删除锁前判断锁是否存在的时候，锁的值在返回的路上，但是呢，锁在这段期间过过期了，而且对比成功，还删除了锁，这时此时最少有两个线程又进入了代码块（因为删除和查询不是一个原子操作）

解决方案：写一个lua脚本来保证原子性，查询的时候顺便删除



## **5实战：自己写的锁**   

缺点：有自旋锁 可能无限重试如果内存分配过小可能导致栈溢出（如果RPC远程调用的话 消费方和提供方都要扛得住高并发，如线程池子大小，控制策略）

```java
public   void  testLock(){
        //1 . 加锁
        String token = UUID.randomUUID().toString();
        Boolean lock = template.opsForValue().setIfAbsent("lock", token, 3L, TimeUnit.SECONDS);
        System.out.println("获取锁状态"+lock);
        if(lock){
            ValueOperations<String, Object> stringObjectValueOperations = template.opsForValue();

            Integer num = Integer.parseInt(String.valueOf(stringObjectValueOperations.get("num")));
            System.out.println("得到num，此时为"+num);

                num = num + 1;
                stringObjectValueOperations.set("num", num.toString());
                System.out.println("修改num的值此时为"+num);

            //删除锁  lua脚本  保证删除锁是原子操作
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            // jedis.eval(script, Collections.singletonList(key), Collections.singletonList(token));

            // 这个值类型要跟lua返回值类型一致才行，否则就会报 java.lang.IllegalStateException
            DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(script);
            redisScript.setResultType(Long.class);

            template.execute(redisScript, Collections.singletonList("lock"),token);
            System.out.println("删除锁完成");
        }else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testLock();
            }
        }
```



## 6.使用redisson分布式锁（redis官方提供） 简便好用

```java
public void useRedissonForLock(){
        //获取一把锁，只要各个代码，用的锁名一样即可
        RLock lock = redissonClient.getLock("lock");
        try {
            lock.lock();

            Integer num =Integer.parseInt(String.valueOf( redisTemplate.opsForValue().get("num")));
            num = num + 1;
            redisTemplate.opsForValue().set("num",num);
        }finally {
            //解锁
            lock.unlock();
        }



    }
```





```java

    public boolean lock() {
        RLock lock = redisson.getLock("lock");
        //lock.lock();//默认是阻塞的。
        //lock.tryLock()；是非阻塞的，尝试一下，拿不到就算了。
        //boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);等待100s内只要能获取到锁，这个锁就10秒超时，

        /**
         *
         */
        lock.lock();
        System.out.println("第一次锁");
        lock.lock();
        System.out.println("第二次锁");
        lock.lock();
        System.out.println("第三次锁");
        //这个线程的任意期间都要获取这把锁，是直接使用的。说明这个锁是可重入锁。


        return  lock.tryLock();


        //哪个线程加的锁一定要在这个线程解


        //加锁
        //业务
        //解锁

    }
```



## 7.几种锁的介绍

### 读写锁

```java
  public String read() {
        RReadWriteLock helloValue = redisson.getReadWriteLock("helloValue");
        RLock readLock = helloValue.readLock();
        readLock.lock();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String a = hello;


        readLock.unlock();
        return a;
    }

    public String write(){

        RReadWriteLock helloValue = redisson.getReadWriteLock("helloValue");
        RLock writeLock = helloValue.writeLock();
        writeLock.lock();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }

        hello = UUID.randomUUID().toString();
        writeLock.unlock();
        return hello;
    }

```



1）如果先调用read()再调用write(),不会有任何影响

2) 如果先调用write()再调用read(),会产生阻塞 ，在修改完成后，读才会被执行

3)错误场景：在写加锁后，在没解锁之前，又给读加了锁，结果可能不尽人意

```java
 public void unlock() {
        RLock lock = redisson.getLock("lock");
        lock.unlock();
        RReadWriteLock helloValue = redisson.getReadWriteLock("helloValue");
        RLock rLock = helloValue.readLock();
        RLock rLock1 = helloValue.writeLock();

        //修改一号记录
        rLock1.lock();
        //修改

        rLock.lock();
    }

```

**总结：两个服务及两个以上服务操作相同数据，如果涉及读写****
      **读加读锁，写加写锁**









## 分布式锁的核心（保证原子性）

   1) 加锁，占坑一定要是原子性的（如果没有，就得给redis中保存数据）

   2)  锁要自动加时

   3)   解锁时也要保证原子性    









# Spring集成Redis配置

![image-20200529170857129](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200529170857129.png)









# Spring集成Redission配置

```java
 @Bean
    RedissonClient redissonClient(){
        Config config = new Config();

        config.useSingleServer().setAddress("redis://47.93.191.23:6379").setPassword("123456");


        return Redisson.create(config);

    }
```







# 缓存使用模式

## 1.Cache-Aside

缓存代码写在业务里







