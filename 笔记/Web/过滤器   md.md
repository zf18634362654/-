**过滤器**   （不涉及业务逻辑，进行请求资源进行统一处理，如服务器定时关闭，或者设置编码,和谐词汇）

![image-20191102113814037](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191102113814037.png)

![image-20191102112605019](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191102112605019.png)



**注解*形式配置** *** 类上加@WebFilter(filterName = "TestFilter2",urlPatterns = "/*") 

​      



**修改编码**

```java
public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
 2         //这样在每个Servlet执行的时候都会先进行这个
 3         HttpServletRequest request = (HttpServletRequest) req;
 4         HttpServletResponse response = (HttpServletResponse) resp;
 5 
 6         request.setCharacterEncoding("utf-8");
 7         response.setContentType("text/html;charset=utf-8");
 8 
 9         //因为有可能不止这一个过滤器,所以需要将所有的过滤器执行
10         //注意 这一行代码一定要写到最后
11         chain.doFilter(req, resp);//资源放行  若有其他过滤器 则执行其他过滤器  所有过滤器执行完以后   然后servlet对数据进行处理  处理完成后 继续执行 chain.doFilter之后的代码
            System.out.println("处理完毕  再次处理响应数据");
12     }
```

**特殊方法**   

```
chain.doFilter(req, resp);
```

这一行代码代表的是如果还有其他的过滤器就调用其它的过滤器，但是需要注意，这一行代码必须写在doFilter方法的最后面

**有关session管理**

![image-20191102113545015](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191102113545015.png)