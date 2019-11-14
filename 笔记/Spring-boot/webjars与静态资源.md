**webjars与静态资源**

### 1静态资源目录

SpringBoot默认配置下，提供了以下几个静态资源目录：

```
/static：  classpath:/static/
/public： classpath:/public/
/resources： classpath:/resources/
/META-INF/resources：classpath:/META-INF/resources/
```

当然，可以通过spring.resources.static-locations配置指定静态文件的位置。**但是要特别注意，一旦自己指定了静态资源目录，系统默认的静态资源目录就会失效。所以系统默认的就已经足够使用了，尽量不要自定义。**

```
    #配置静态资源
    spring:
      resources:
        #指定静态资源目录
        static-locations: classpath:/mystatic/
```

### favicon.ico图标

如果在配置的静态资源目录中有favicon.ico文件，SpringBoot会自动将其设置为应用图标。

### 欢迎页面

SpringBoot支持静态和模板欢迎页，它首先在静态资源目录查看index.html文件做为首页，若未找到则查找index模板。

### 2.访问引入的js文件

SpringBoot将webjar中路径`/webjars/**`的访问重定向到项目的`classpath:/META-INF/resources/webjars/*`。例如：在html内访问静态资源可以使用目录`/webjars/jquery/1.12.4/jquery.js`.

```
<script src="/webjars/jquery/1.12.4/jquery.min.js "></script>
```

## 三、自动检测依赖的版本

如果使用 Spring 4.2 以上的版本，并且加入 webjars-locator 组件，就不需要在 html 添加依赖的时候填写版本。

```
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>webjars-locator</artifactId>
    <version>0.30</version>
</dependency>
```

引入 webjars-locator 值后可以省略版本号:

```
<script src="/webjars/jquery/jquery.min.js"></script>
```

注意：只能去掉版本号