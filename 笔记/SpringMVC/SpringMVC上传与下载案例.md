SpringMVC上传与下载案例

登陆校验时可以在标签后加入<scan>标签

图片的超链接不能直接从硬盘中获取数据，只能从Tomcat中拿 

```html
<input type="file">
```

用jquer获取该标签对象时 只能访问其Val 不能修改或加入值

   match(/^    $/)正则表达式中 以/ /包围 以^作为开始符号  $作为结束符号

![image-20191025180201357](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191025180201357.png)

上传底层    先通过封装的文件读入用户的输入流   再通过**普通输出流**写到服务器硬盘上



![image-20191025180443363](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191025180443363.png)

下载文件底层  通过超链接进入servlet  获取文件的输入流  再通过**Servlet输出流**写给用户





```javascript
$(function(){
	$("a").click(function(){
	  //parent()父标签
	  //prev()前一个兄弟标签
	  //jquery中 规范,对象名以$开头
	  var $td=$(this).parent().prev();
	  //html()返回值为字符串
	   $td.html(parseInt($td.html())+1);				
	});
	
		 
})
```

更新时可以采用AJAX的方式实现不刷新跳转 对于某些不重要的数据不需要考虑分布式等

采用从数据库重新拿数据会浪费性能 慢  