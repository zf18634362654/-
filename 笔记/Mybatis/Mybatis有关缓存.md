Mybatis

**缓存**



![image-20191028204353886](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191028204353886.png)

**缓存流程**

![image-20191028204433467](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191028204433467.png)

图解![image-20191028204458735](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191028204458735.png)

**二级缓存**

![image-20191028204609764](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191028204609764.png)

**开启二级缓存相当于共用一个SqlSession对象**

在mybaits配置文件中加入  下列语句即可开启二级缓存

```java
<cache readOnly="true"> </cache>
```

