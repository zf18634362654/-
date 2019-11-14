**SpringBoot拦截器的实现以及请求链路****

滤器、监听器都属于Servlet的api，我们在开发中处理利用以上的进行过滤web请求时，还可以使用Spring提供的拦截器(HandlerInterceptor)进行更加精细的控制。

编写自定义拦截器类

```java
@Slf4j
public class CustomHandlerInterceptor implements HandlerInterceptor{

 @Override
 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
   throws Exception {
  log.info("preHandle:请求前调用");
  //返回 false 则请求中断
  return true;
 }

 @Override
 public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
   ModelAndView modelAndView) throws Exception {
  log.info("postHandle:请求后调用");

 }

 @Override
 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
   throws Exception {
  log.info("afterCompletion:请求调用完成后回调方法，即在视图渲染完成后回调");

 }

}
```

通过继承WebMvcConfigurerAdapter注册拦截器。笔者在写作完成后，发现WebMvcConfigurerAdapter类已经被废弃，请实现WebMvcConfigurer接口完成拦截器的注册。

```java
@Configuration
//废弃：public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter{
public class MyWebMvcConfigurer implements WebMvcConfigurer 
 @Override
  public void addInterceptors(InterceptorRegistry registry) {
   //注册拦截器 拦截规则
  //多个拦截器时 以此添加 执行顺序按添加顺序
  registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/*");
  }
	
 @Bean
 public static HandlerInterceptor getHandlerInterceptor() {
  return new CustomHandlerInterceptor();
 }
}
```

## 三、请求链路说明

![img](https://box.kancloud.cn/dc392b1f9ce0145707da6493665ff7f4_535x457.png)

![img](https://box.kancloud.cn/a8ac4b58376ce29cf0ee7d80af763f40_1391x239.png)

![img](https://box.kancloud.cn/f663fc3c415b198dd6e4e8a5136a6b59_819x460.png)