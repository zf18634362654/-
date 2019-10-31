**@ResponseBody**

![image-20191026090129075](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191026090129075.png)

出现乱码时使用其produces 属性修改Content-Type

```java
@RequestMapping(value="",produces="text/html;charset=utf-8")
```

拦截器底层：栈 先进后出

*SpringMVC组件*

**前端控制器**

![image-20191026091929685](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191026091929685.png)

**处理器映射器**

![image-20191026092541511](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191026092541511.png)

**处理器适配器**

![image-20191026092908034](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191026092908034.png)

**处理器**

![image-20191026093734071](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191026093734071.png)

![image-20191026093801566](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191026093801566.png)

**视图解析器**

![image-20191026094241724](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191026094241724.png)

![image-20191026094256566](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191026094256566.png)

