# JQuery

jquery-3.3.1.min.js ：压缩版，发布版84.8KB
jquery-3.3.1.js ：常规版，开发版265KB 

 

**注意**   有关调试

html中 如果出错，不提示！
如果调试工具（F12）没有错误提示，但显示效果不一致，考虑html错误
常见错误：
引入js库时
必须是	<script type="text/javascript" src="...." >
	</script>

不能

	<script type="text/javascript" src="...." />

## 初始化函数



### **$(document).ready(function(){})：**

**初始化函数， 当网页中的dom元素（不包含图片、视频、资源）全部加载完毕后 立刻执行**

### **onload :  

```
<body onload="init()"> 
```

​	**javascript，初始化函数，当网页中的dom元素（关联图片、视频、资源）全部加载完毕后 立刻执行****



**jquery初始化函数简化：**
**$(function(){...});**

**$等价于jQuery**





# dom模型：

​	**将html  xml等文档结构的标签语言 看成dom模型**



# Dom对象：

dom节点有三种类型：
	元素节点    <html>   <ul>... <p>
	属性节点  ：title  src  alt ...
	文本节点： 文本节点

以上三种节点类型的具体对象 就是Dom对象。

​	**使用层面： 凡是JavaSCript能够直接操作的对象，就是Dom对象。**
​	例如，var title = document.getElementById("myTitile");通过js获取到的title对象 就是一个dom对象（就是<p>对象）**







# jQuery对象：

​	凡是jQuery能够直接操作的对象，就是jQuery对象。
​	例如：var $title = $("#myTitile") ; 通过jquery获取到的 $title 就是一个jquery对象。
​	同样一个元素，即可以成为一个dom对象（javascript对象），也可以成为一个jquery对象
注意：dom对象 只适用于js的各种语法（函数、属性），jquery对象只用于jquery的各种语法（函数、属性）。 
dom对象和jquery对象的各自独立。
例如
​	title 是dom对象，因此可以使用js属性或方法 title.innerHTML


	$title 是jquery对象，因此可以使用jquery属性或方法  $title.html()

建议：
	js对象 直接写title
	jquery 加上$，例如$title





# dom对象和jquery对象的转换：

​	 title.innerHTML;
​		tile ->$title  

	$title.html();
		$title->title

## dom对象->jquery对象 :

**jquery工厂，  $(dom对象)**

​		

## jquery对象 ->dom对象：

​	基础：jquery对象默认是一个数组 或集合   ；dom对象默认是一个单独的对象

	数组：jquery对象[0]
	集合：jquery对象.get(0)






# Jquery选择器：jquery根基

## 1基本选择器

```
标签选择器：
	$("标签名")
		$("p").html() 获取p标签对象，是jquery对象形式的
		$("p").length
```



	类选择器：
	$(".class值")
	
	id选择器
	$("#id值")


	并集(或)选择器  逗号,
		$(".class值,#id值")


	交集选择器（同时存在）	连续直接写
	
		$(".class值#id值")
		$("p.myStyle").html()：选中 即是p标签，并且class的值是myStyle
		注意：不能出现歧义
			错误写法 $(".myStylep").html()
		交集选择器 在交接处 只能是.或#开头的选择器




	全局选择器：选中全部的元素
		
		$("*")




## 2层次选择器（只取后面的那些元素）

相邻选择器 +
		$("选择器1+选择器2")


	同辈选择器	 ~	(后边所有的同辈元素)
		$("选择器1~选择器2")
	
	后代选择器 空格
		$("选择器1 选择器2")



	子代选择器 >
		$("选择器>选择器2")



```
<html>

	<zz>
	<aaa>
		xx
		yy
		nn
	</aaa>	
	<bbb>


</html>
```


​		





## 3属性选择器  [ ... ]





$("[属性名]")

		$("[class]") :选中全部元素中 有class属性的 元素
	
	$("[属性名=属性值]")
		$("[class=xxx]")  
		$("[class='xxx']")    
	
	$("[class!=a]")  不等于， 包含两种： 有class但值不是a,   没有class
	
	$("[class^=a]")  class以a开头的元素
	$("[class$=a]")  class以a结尾的元素
	$("[class*=a]")  class有a的元素
**例子**< p  name="zs" >  name是属性



## 4过滤选择器	

**过滤选择器的一些方法 和其他函数类型，例如 $("ul>li:first")等价于$("ul>li").first()**
	**有些不同，例如，  可以$("ul>li:odd")	；错误$("ul>li").odd();**

	a.基本过滤选择器（从0开始）
**:first：最开头那一个**
**:last：最后那一个**
**:even：偶数**
**:odd:奇数**
**:eq(index)：第index个**

**:gt(index) : >index的全部元素**
**:lt(index): <index的全部元素**
**:not(选择器) :除了...以外**
**:header:选中所有的标题元素 h1 h2 <h1>**
**:focus: 获取当前焦点的元素**





## 5.可见性选择器

:visible ：选中所有可见的元素
	:hidden：选中所有隐藏的元素







## 事件 ，事件函数（事件方法）

js: onXxx
	onclick();
	写在<script>内，ready()外；

jquery:没有on  
	click(); 
	ready()内；

	ready(function(){
	
		$(选择器).事件类型(function(){
			...
		});
	});

windows事件：ready();
鼠标事件：
	click()：单击事件
	mouseover():鼠标悬浮
	mouseout():鼠标离开
http://www.w3school.com.cn/tags/html_ref_eventattributes.asp

键盘事件：
	keydown():按键 从上往下的 过程
	keypress() ： 按键被压到 最底部
	keyup()：松开按键

	1.前端的一些事件、方法，会在某些情况下失效。 2.兼容性问题

可以通过event.keyCode指定具体的按键

```javascript
		$("body").keydown(function(event){
			if(event.keyCode == 13){
				alert("回车。。。...");
			}
		});
```




## 操作DOM

​	a.样式操作
​	i.设置css()
​		jquery对象.css("属性名","属性值");
​		jquery对象.css({ "属性名":"属性值"      ,"属性名":"属性值" ,...,"属性名":"属性值"     });
​	ii.追加或移除样式class
​		addClass("x");
​		addClass("x x x");
​		removeClass(x);
​		removeClass(x x );
​		removeClass():移除全部样式
​		toggleClass("x x x"):切换追加与移除

	b.内容操作
		html()：获取值 ，获取的是元素 的内容 ，包含了 元素内部的 各种标签
		html(xxxx) :先渲染，后显示
	
		text()：：获取值 ，值获取文本值
		text(xxxx)：將值原样显示，没有渲染
	
		val()：获取value值
		val(xxx)：设置value值
	
	c.节点与属性操作
		i.节点操作
			①查询节点  （jquery选择器）
			②创建节点  ：  $()
				$(选择器):获取节点		
				$(DOM对象)：转换
				$(html字符串)，   $("<li onclick="..">xxx</li>")
			③插入节点  文档
			④替换节点
				$X.replaceWith($Y)	：用$Y替换$X	
				replaceAll();
			⑤删除节点
				remove()：彻底删除
				detach()：将结点删除，但关联的事件、数据不会删除（不推荐使用）
				empty()	：只删除内容
			⑥克隆节点
				clone(true|false)
				$(document).ready(function(){     
					$("li").click(function(){  ... });
				});			
	
				  <li>xxxx</li>
	
		ii.属性操作 
			attr("属性名") ：获取属性值
	
			attr("属性名","属性值") ：设置属性值
			attr({ "属性名":"属性值",    "属性名":"属性值" ,  "属性名":"属性值" } );
			删除属性值
			removeAttr("属性名");
		
	d.获取集合与遍历集合
		子节点集合
		 $(...).children( "li")
		后代集合(不推荐使用，影响性能)
		 $(...).find( "li")


<body>
	<div>
		<ul>
			<li>...</li>
		</ul>
	</div>
</body>


		同辈集合
			next()：后一个  +
			prev(): 前一个
			siblings()：同辈，左、右
	
		前辈
			
			parent():父代
			parents("ul"):祖先
	
	过滤集合：
		i.很多方法的()就是一个过滤选择器
		ii.filter("选择器...");  
	
	遍历集合：
	$(...).each(function(index,element){
	
	});


​	
CSS-dom操作:
​	height(500) ;
​	width(500)

	offset()：偏移量（左上角的点）,left top
	offset(function(n,oldOffset){   ... })
	
	offsetParent()：获取  （已定位）的最近的祖先元素
		已定位：元素position属性(默认static)被设置为了relative  absolute  或fixed  
	
	scrollLet()
	scrollTop()

## 重要：表单校验，可以减轻对服务端的访问次数

​	a.获取要校验的元素值(选择器)	用户名、密码
​	b.通过 字符串处理方法、或者 正则表达式等手段 进行校验
​		"aaa@abc.com".indexOf("@") !=-1
​	c.触发校验的方法或事件（校验时机）
​		blur()：失去焦点时触发
​		submit()：当点击表单的 “提交submit”按钮时 触发
​		



		onblur="xxx()"
		onsubmit="xx()"
		function check(){
		return true;
		}
		<form onsubmmit="return check()"> </form>

submit()或onsubmit的返回值 会决定表单是否跳转，如果返回true则正常跳转；如果返回false 则终止条件

	在校验时建议的写法：
	if(....不合理的情况) alert() ; return false ;
	if(....不合理的情况) alert() ; return false ;
	if(....不合理的情况) alert() ; return false ;
	if(....不合理的情况) alert() ; return false ;
	
	return true ;

正则表达式：用于定义规则
	email="aaa" ;

	正则表达式.test( email);	
使用：
	手写的正则表达式规则.test(校验的值) -> true|false


正则表达式 误区：有些时候完全没必要使用