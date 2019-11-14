**有关MOCK**

![image-20191108180738876](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108180738876.png)

![image-20191108180847157](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108180847157.png)

![image-20191108180930771](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108180930771.png)

![image-20191108181731601](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108181731601.png)

![image-20191108182217802](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108182217802.png)

原因：测试过程中 事务会交给Spring进行管理

​            真实运行时  事务交给的是数据库     与预期不符      

![image-20191108182507870](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108182507870.png)

<img src="C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108182833827.png" alt="image-20191108182833827"  />

**MockMVC没有容器支持 不能实现Spring的依赖注入**

![image-20191108183146593](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108183146593.png)



![image-20191108183425691](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108183425691.png)

@AutoConfiguerMockMvc相当于以下代码

```java
  private MockMvc mockMvc;

	@BeforeAll
	public  void setUp(){
		mockMvc= MockMvcBuilders.standaloneSetup(new        PeopleHandler()).build();

	}
```

![image-20191108184351153](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108184351153.png)

![image-20191108193710263](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108193710263.png)

![image-20191108193732400](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108193732400.png)

![image-20191108195848154](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108195848154.png)

![image-20191108200119467](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191108200119467.png)