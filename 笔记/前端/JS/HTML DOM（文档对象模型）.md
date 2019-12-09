

## HTML DOM（文档对象模型）

**当网页被加载时，浏览器会创建页面的文档对象模型（*D*ocument *O*bject *M*odel）。**

 **通过 HTML DOM，JavaScript 能够访问和改变 HTML 文档的所有元素。** 

*HTML DOM* 模型被结构化为*对象树*：

### 对象的 HTML DOM 树

![DOM HTML 树](https://www.w3school.com.cn/i/ct_htmltree.gif)

- JavaScript 能改变页面中的所有 HTML 元素
- JavaScript 能改变页面中的所有 HTML 属性
- JavaScript 能改变页面中的所有 CSS 样式
- JavaScript 能删除已有的 HTML 元素和属性
- JavaScript 能添加新的 HTML 元素和属性
- JavaScript 能对页面中所有已有的 HTML 事件作出反应
- JavaScript 能在页面中创建新的 HTML 事件

![image-20191126180647735](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191126180647735.png)





## HTML DOM 方法



**HTML DOM 方法是您能够（在 HTML 元素上）执行的动作。**

**HTML DOM 属性是您能够设置或改变的 HTML 元素的值。**



### DOM 编程界面

HTML DOM 能够通过 JavaScript 进行访问（也可以通过其他编程语言）。

在 DOM 中，所有 HTML 元素都被定义为*对象*。

编程界面是每个对象的属性和方法。

*属性*是您能够获取或设置的值（就比如改变 HTML 元素的内容）。

*方法*是您能够完成的动作（比如添加或删除 HTML 元素）。

### getElementById 方法

访问 HTML 元素最常用的方法是使用元素的 id。

在上面的例子中，getElementById 方法使用 id="demo" 来查找元素。

### innerHTML 属性

获取元素内容最简单的方法是使用 innerHTML 属性。

innerHTML 属性可用于获取或替换 HTML 元素的内容。

innerHTML 属性可用于获取或改变任何 HTML 元素，包括 <html> 和 <body>。







## 查找 HTML 元素

通常，通过 JavaScript，您需要操作 HTML 元素。

为了达成此目的，您需要首先找到这些元素。有好几种完成此任务的方法：

- **通过 id 查找 HTML 元素**
- **通过标签名查找 HTML 元素**
- **通过类名查找 HTML 元素**
- **通过 CSS 选择器查找 HTML 元素**
- **通过 HTML 对象集合查找 HTML 元素**



### 通过 id 查找 HTML 元素

```javascript
var myElement = document.getElementById("intro");
```

如果元素被找到，此方法会以对象返回该元素（在 myElement 中）。

如果未找到元素，myElement 将包含 null。



### 通过标签名查找 HTML 元素



```
var x = document.getElementsByTagName("p");
```

若查找的标签为多个时，返回的是数组



### 通过类名查找 HTML 元素



```
var x = document.getElementsByClassName("intro");
```





### 通过 CSS 选择器查找 HTML 元素

如果您需要查找匹配指定 CSS 选择器（id、类名、类型、属性、属性值等等）的所有 HTML 元素，请使用 querySelectorAll() 方法。

本例返回 class="intro" 的所有 <p> 元素列表：

### 

```
var x = document.querySelectorAll("p.intro");
```



##  改变 HTML

 **HTML DOM 允许 JavaScript 改变 HTML 元素的内容。** 

### 改变 HTML 输出流

 在 JavaScript 中，document.write() 可用于直接写入 HTML 输出流： 

 千万不要在文档加载后使用 document.write()。这么做会覆盖文档。 

### 改变 HTML 内容



改 HTML 文档内容最简单的方法是，使用 innerHTML 属性。

如需修改 HTML 元素的内容，请使用此语法：

```
document.getElementById(id).innerHTML = new text
```

### 改变属性的值

```
<!DOCTYPE html>
<html>
<body>

<img id="myImage" src="smiley.gif">

<script>
document.getElementById("myImage").src = "landscape.jpg";
</script>

</body>
</html> 
```



## 使用事件

HTML DOM 允许您在事件发生时执行代码。

当“某些事情”在 HTML 元素上发生时，浏览器会生成事件：

- 点击某个元素时
- 页面加载时
- 输入字段被更改时

```
<h1 onclick="changeText(this)">请点击此文本！</h1>

<script>
function changeText(id) {
  id.innerHTML = "谢谢！";
} 
</script>   //可效仿
```

### onload 和 onunload 事件

当用户进入后及离开页面时，会触发 onload 和 onunload 事件。

onload 事件可用于检测访问者的浏览器类型和浏览器版本，然后基于该信息加载网页的恰当版本。

onload 和 onunload 事件可用于处理 cookie

```
<body onload="checkCookies()">

<p id="demo"></p>

<script>
function checkCookies() {
  var text = "";
  if (navigator.cookieEnabled == true) {
    text = "Cookie 已启用";
  } else {
    text = "Cookie 未启用";
  }
  document.getElementById("demo").innerHTML = text;
}
</script>

```





### onchange 事件

onchange 事件经常与输入字段验证结合使用。

```
<script>
function myFunction() {
  var x = document.getElementById("fname");
  x.value = x.value.toUpperCase();
}
</script>
</head>
<body>

请输入您的名字：<input type="text" id="fname" onchange="myFunction()">

<p>离开输入字段时，会触发一个函数，将输入文本转换为大写。</p>
```

### onmouseover 和 onmouseout 事件

onmouseover 和 onmouseout 事件可用于当用户将鼠标移至 HTML 元素上或移出时触发某个函数：



##  事件监听器

### addEventListener() 方法

### 

添加当用户点击按钮时触发的事件监听器：

```
document.getElementById("myBtn").addEventListener("click", displayDate);
```

- **addEventListener() 方法为指定元素指定事件处理程序。**
- **addEventListener() 方法为元素附加事件处理程序而不会覆盖已有的事件处理程序。**
- **您能够向一个元素添加多个事件处理程序。**
- **您能够向一个元素添加多个相同类型的事件处理程序，例如两个 "click" 事件。**
- **您能够向任何 DOM 对象添加事件处理程序而非仅仅 HTML 元素，例如 window 对象。**
- **addEventListener() 方法使我们更容易控制事件如何对冒泡作出反应。**
- **当使用 addEventListener() 方法时，JavaScript 与 HTML 标记是分隔的，已达到更佳的可读性；即使在不控制 HTML 标记时也允许您添加事件监听器。**
- **您能够通过使用 removeEventListener() 方法轻松地删除事件监听器。**



```
lement.addEventListener(event, function, useCapture);
```

**第一个参数是事件的类型（比如 "click" 或 "mousedown"）。**

**第二个参数是当事件发生时我们需要调用的函数。**

**第三个参数是布尔值，指定使用事件冒泡还是事件捕获。此参数是可选的。**

**注意：请勿对事件使用 "on" 前缀；请使用 "click" 代替 "onclick"。**



### 向元素添加事件处理程序

### 

当用户点击某个元素时提示 "Hello World!"：

```
element.addEventListener("click", function(){ alert("Hello World!"); });
```



**您能够向相同元素添加不同类型的事件：**

### 

```
element.addEventListener("mouseover", myFunction);
element.addEventListener("click", mySecondFunction);
element.addEventListener("mouseout", myThirdFunction);
```



### 向 Window 对象添加事件处理程序

addEventListener() 允许您将事件监听器添加到任何 HTML DOM 对象上，比如 HTML 元素、HTML 对象、window 对象或其他支持事件的对象，比如 xmlHttpRequest 对象。

### 

添加当用户调整窗口大小时触发的事件监听器：

```
window.addEventListener("resize", function(){
    document.getElementById("demo").innerHTML = sometext;
});
```





### 事件冒泡还是事件捕获？

在 HTML DOM 中有两种事件传播的方法：冒泡和捕获。

事件传播是一种定义当发生事件时元素次序的方法。假如 <div> 元素内有一个 <p>，然后用户点击了这个 <p> 元素，应该首先处理哪个元素“click”事件？

在冒泡中，最内侧元素的事件会首先被处理，然后是更外侧的：首先处理 <p> 元素的点击事件，然后是 <div> 元素的点击事件。

在捕获中，最外侧元素的事件会首先被处理，然后是更内侧的：首先处理 <div> 元素的点击事件，然后是 <p> 元素的点击事件。

在 addEventListener() 方法中，你能够通过使用“useCapture”参数来规定传播类型：

```
addEventListener(event, function, useCapture);
```

默认值是 false，将使用冒泡传播，如果该值设置为 true，则事件使用捕获传播。





### removeEventListener() 方法

removeEventListener() 方法会删除已通过 addEventListener() 方法附加的事件处理程序：

### 

```
element.removeEventListener("mousemove", myFunction);
```



JS Window

## Window 对象

所有浏览器都支持 *window* 对象。它代表浏览器的窗口。

所有全局 JavaScript 对象，函数和变量自动成为 window 对象的成员。

全局变量是 window 对象的属性。

全局函数是 window 对象的方法。

甚至（HTML DOM 的）document 对象也是 window 对象属性：

```
window.document.getElementById("header");
```

等同于：

```
document.getElementById("header");
```

- **window.open() - 打开新窗口**
- **window.close() - 关闭当前窗口**
- **window.moveTo() -移动当前窗口**
- **window.resizeTo() -重新调整当前窗口**





## JS Location



## Window Location

window.location* 对象可不带 window 前缀书写。

一些例子：

- **window.location.href 返回当前页面的 href (URL)**
- **window.location.hostname 返回 web 主机的域名**
- **window.location.pathname 返回当前页面的路径或文件名**
- **window.location.protocol 返回使用的 web 协议（http: 或 https:）**
- **window.location.assign 加载新文档**



### Window Location Href

window.location.href 属性返回当前页面的 URL。

的 href (URL)：

```
document.getElementById("demo").innerHTML = "页面位置是 " + window.location.href;
```

结果是：

```
页面位置是 http://www.w3school.com.cn/js/js_window_location.asp
```





### Window Location 主机名

window.location.hostname 属性返回（当前页面的）因特网主机的名称。

### 

显示主机的名称：

```
document.getElementById("demo").innerHTML = "页面主机名是 " + window.location.hostname;
```

结果是：

```
页面主机名是 www.w3school.com.cn
```





### Window Location 路径名

window.location.pathname 属性返回当前页面的路径名。

### 

显示当前 URL 的路径名：

```
document.getElementById("demo").innerHTML = "页面路径是 " + window.location.pathname;
```

结果是：

```
页面路径是 /js/js_window_location.asp
```



### Window Location 协议

window.location.protocol 属性返回页面的 web 协议。

### 

显示 web 协议：

```
document.getElementById("demo").innerHTML = "页面协议是 " + window.location.protocol;
```

结果是：

```
页面协议是 http:
```





### Window Location 端口

window.location.port 属性返回（当前页面的）互联网主机端口的编号。

### 

显示主机的端口号：

```
document.getElementById("demo").innerHTML = "端口号是： " + window.location.port;
```





## Window History

**window.history 对象包含浏览器历史。**

## 

- window.history 对象可不带 window 书写。

  为了保护用户的隐私，JavaScript 访问此对象存在限制。

  ### 一些方法：

  - history.back() - 等同于在浏览器点击后退按钮
  - history.forward() - 等同于在浏览器中点击前进按钮

## 弹出框

**JavaScript 有三种类型的弹出框：警告框、确认框和提示框。**

### 警告框

如果要确保信息传递给用户，通常会使用警告框。

当警告框弹出时，用户将需要单击“确定”来继续。

### 

```
window.alert("sometext");
```

window.alert() 方法可以不带 window 前缀来写。

### 

```
alert("我是一个警告框！");
```





### 确认框

如果您希望用户验证或接受某个东西，则通常使用“确认”框。

当确认框弹出时，用户将不得不单击“确定”或“取消”来继续进行。

如果用户单击“确定”，该框返回 true。如果用户单击“取消”，该框返回 false。

### 

```
window.confirm("sometext");
```

window.confirm() 方法可以不带 window 前缀来编写。

### 

```
var r = confirm("请按按钮");
if (r == true) {
    x = "您按了确认！";
} else {
    x = "您按了取消！";
}
```



### 提示框

如果您希望用户在进入页面前输入值，通常会使用提示框。

当提示框弹出时，用户将不得不输入值后单击“确定”或点击“取消”来继续进行。

如果用户单击“确定”，该框返回输入值。如果用户单击“取消”，该框返回 NULL。

### 

```
window.prompt("sometext","defaultText");
```

window.prompt() 方法可以不带 window 前缀来编写。

### 

```
var person = prompt("请输入您的姓名", "比尔盖茨");
if (person != null) {
    document.getElementById("demo").innerHTML = "你好 " + person + "！今天过的怎么样？";
}
```





## Cookies

Clookie 是在您的计算机上存储在小的文本文件中的数据。

当 web 服务器向浏览器发送网页后，连接被关闭，服务器会忘记用户的一切。

Cookie 是为了解决“如何记住用户信息”而发明的：

- 当用户访问网页时，他的名字可以存储在 cookie 中。
- 下次用户访问该页面时，cookie 会“记住”他的名字。

Cookie 保存在名称值对中，如：

```
username = Bill Gatesl
```

当浏览器从服务器请求一个网页时，将属于该页的 cookie 添加到该请求中。这样服务器就获得了必要的数据来“记住”用户的信息。

如果浏览器已关闭本地 cookie 支持，则以下实例均无法工作。





## HTML DOM 导航

### DOM 节点

根据 W3C HTML DOM 标准，HTML 文档中的所有事物都是节点：

- 整个文档是文档节点
- 每个 HTML 元素是元素节点
- HTML 元素内的文本是文本节点
- 每个 HTML 属性是属性节点
- 所有注释是注释节点

![DOM HTML 树](https://www.w3school.com.cn/i/ct_htmltree.gif)

能够创建新节点，还可以修改和删除所有节点。







### 节点关系

节点树中的节点彼此之间有一定的等级关系。

- 术语（父、子和同胞，parent、child 以及 sibling）用于描述这些关系。
- 在节点树中，顶端节点被称为根（根节点）。
- 每个节点都有父节点，除了根（根节点没有父节点）。
- 节点能够拥有一定数量的子
- 同胞（兄弟或姐妹）指的是拥有相同父的节点。



![DOM HTML 树](https://www.w3school.com.cn/i/dom_navigate.gif)

```html
<html>

   <head>
       <title>DOM 教程</title>
   </head>

  <body>
       <h1>DOM 第一课</h1>
       <p>Hello world!</p>
   </body>

</html> 
```

- <html> 是根节点
- <html> 没有父
- <html> 是 <head> 和 <body> 的父
- <head> 是 <html> 的第一个子
- <body> 是 <html> 的最后一个子

同时：

- <head> 有一个子：<title>

- <title> 有一个子（文本节点）："DOM 教程"

- <body> 有两个子：<h1> 和 <p>

- <h1> 有一个子："DOM 第一课"

- <p> 有一个子："Hello world!"

  

### 在节点之间导航

通过 JavaScript，您可以使用以下节点属性在节点之间导航：

- parentNode
- childNodes[*nodenumber*]
- firstChild
- lastChild
- nextSibling
- previousSibling



### 子节点和节点值

DOM 处理中的一种常见错误是认为元素节点中包含文本。

### 

```
<title id="demo">DOM 教程</title> 
```

（上面例子中的）元素节点 <title> 不包含文本。

它包含了值为 "DOM 教程" 的*文本节点*。

文本节点的值能够通过节点的 innerHTML 属性进行访问：

```
var myTitle = document.getElementById("demo").innerHTML;
```

访问 innerHTML 属性等同于访问首个子节点的 nodeValue：

```
var myTitle = document.getElementById("demo").firstChild.nodeValue;
```

也可以这样访问第一个子节点：

```
var myTitle = document.getElementById("demo").childNodes[0].nodeValue;
```



### nodeName 属性

nodeName 属性规定节点的名称。

- nodeName 是只读的
- 元素节点的 nodeName 等同于标签名
- 属性节点的 nodeName 是属性名称
- 文本节点的 nodeName 总是 #text
- 文档节点的 nodeName 总是 #document





```html
<h1 id="id01">我的第一张网页</h1>
<p id="id02">Hello!</p>

<script>
document.getElementById("id02").innerHTML  = document.getElementById("id01").nodeName;//H1
</script>
```

 **注释：**nodeName 总是包含 HTML 元素的大写标签名。 







##  HTML DOM 元素（节点）





**添加和删除节点（HTML 元素）**

### 创建新 HTML 元素（节点）

如需向 HTML DOM 添加新元素，您必须首先创建这个元素（元素节点），然后将其追加到已有元素。

### 

```
<div id="div1">
<p id="p1">这是一个段落。</p>
<p id="p2">这是另一个段落。</p>
</div>

<script>
var para = document.createElement("p");
var node = document.createTextNode("这是新文本。");
para.appendChild(node);

var element = document.getElementById("div1");
element.appendChild(para);
</script>
```





这段代码创建了一个新的 <p> 元素：

```
var para = document.createElement("p");
```

如需向 <p> 元素添加文本，则必须首先创建文本节点。这段代码创建了一个文本节点：

```
var node = document.createTextNode("这是一个新段落。");
```

然后您需要向 <p> 元素追加这个文本节点：

```
para.appendChild(node);
```

最后您需要向已有元素追加这个新元素。

这段代码查找一个已有的元素：

```
var element = document.getElementById("div1");
```

这段代码向这个已有的元素追加新元素：

```
element.appendChild(para);
```





### 创建新 HTML 元素 - insertBefore()

前面例子中的 appendChild() 方法，追加新元素作为父的最后一个子。

除此之外您还可以使用 insertBefore() 方法：

### 

```
<div id="div1">
//插在了这里
<p id="p1">这是一个段落。</p>
<p id="p2">这是另一个段落。</p>
</div>

<script>
var para = document.createElement("p");
var node = document.createTextNode("这是新文本。");
para.appendChild(node);

var element = document.getElementById("div1");
var child = document.getElementById("p1");
element.insertBefore(para, child);
</script>
```