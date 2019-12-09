# HTML





超文本标记语言（英语：HyperText Markup Language，简称：HTML）是一种用于创建网页的标准标记语言。

您可以使用 HTML 来建立自己的 WEB 站点，HTML 运行在浏览器上，由浏览器来解析

\**注意：***对于中文网页需要使用* **** *声明编码，否则会出现乱码。有些浏览器(如 360 浏览器)会设置 GBK 为默认编码，则你需要设置为* **。** 



## 实例解析

- **** 声明为 HTML5 文档
- **** 元素是 HTML 页面的根元素
- **** 元素包含了文档的元（meta）数据，如 **** 定义网页编码格式为 **utf-8**。
- **** 元素描述了文档的标题
- **** 元素包含了可见的页面内容
- **** 元素定义一个大标题
- **** 元素定义一个段落



## HTML 图像

HTML 图像是通过标签 <img> 来定义的.

## 

<img src="/images/logo.png" width="258" height="39" />

### 引用方式

1、***.html** 文件跟 ***.jpg** 文件(f盘)在不同目录下：

```
<img src="file:///f:/*.jpg" width="300" height="120"/>
```

2、***.html** 文件跟 ***.jpg** 图片在相同目录下：

```
<img src="*.jpg" width="300" height="120"/>
```

3、***.html*****.jpg**

a、图片 ***.jpg** 在 **image** 文件夹中，*.html 跟 **image** 在同一目录下：

```
<img src="image/*.jpg/"width="300" height="120"/>
```

b、图片 ***.jpg** 在 **image** 文件夹中，***.html** 在 **connage** 文件夹中，**image** 跟 **connage** 在同一目录下：

```
<img src="../image/*.jpg/"width="300" height="120"/>
```

4、如果图片来源于网络，那么写绝对路径：

```
<img src="http://static.runoob.com/images/runoob-logo.png" width="300" height="120"/>
```





### **HTML 中 href、src 区别**

href 是 Hypertext Reference 的缩写，表示超文本引用。用来建立当前元素和文档之间的链接。常用的有：link、a。例如：

```
<link href="reset.css" rel=”stylesheet“/>
```

浏览器会识别该文档为 css 文档，并行下载该文档，并且不会停止对当前文档的处理。这也是建议使用 link，而不采用 @import 加载 css 的原因。 src 是 source 的缩写，src 的内容是页面必不可少的一部分，是引入。src 指向的内容会嵌入到文档中当前标签所在的位置。常用的有：img、script、iframe。例如:

```
<script src="script.js"></script>
```

当浏览器解析到该元素时，会暂停浏览器的渲染，直到该资源加载完毕。这也是将js脚本放在底部而不是头部得原因。

简而言之，src 用于替换当前元素；href 用于在当前文档和引用资源之间建立联系。





**MacOS 如何加载图片以及文件目录有空格**

MacOS 是没有硬盘分区的，所以引用文件直接



## HTML 空元素

没有内容的 HTML 元素被称为空元素。空元素是在开始标签中关闭的。

<br> 就是没有关闭标签的空元素（<br> 标签定义换行）。

在 XHTML、XML 以及未来版本的 HTML 中，所有元素都必须被关闭。

在开始标签中添加斜杠，比如 <br />，是关闭空元素的正确方法，HTML、XHTML 和 XML 都接受这种方式。

即使 <br> 在所有浏览器中都是有效的，但使用 <br /> 其实是更长远的保障。

总结

1. **一些标签的使用，切记所有标签都需要闭合，不管是单体标签还是成对标签。（尽管目前浏览器是识别有些标签不闭合的情况，但是取的最好的保证兼容性，使用闭合）**

2. **标签写法要用小写字母（有些版本对大小写可认为相同，而xhtml中强制使用小写）**

## HTML 属性

 提**示: 在某些个别的情况下，比如属性值本身就含有双引号，那么您必须使用单引号，例如：name='John "ShotGun" Nelson'** 

1. **属性和属性值，尽量小写，本来这样做也方便些。**
2. **class 属性可以多用 class=" " （引号里面可以填入多个class属性）**
3. **id 属性只能单独设置 id=" "（只能填写一个，多个无效）**





## HTML 标题



标题（Heading）是通过 <h1> - <h6> 标签进行定义的。



```
<hr> 标签在 HTML 页面中创建水平线。
<h1> 定义最大的标题。 <h6> 定义最小的标题。

```

 **注释: 浏览器会自动地在标题的前后添加空行。** 





## 标题很重要

请确保将 HTML 标题 标签只用于标题。不要仅仅是为了生成**粗体**或**大号**的文本而使用标题。

搜索引擎使用标题为您的网页的结构和内容编制索引。

因为用户可以通过标题来快速浏览您的网页，所以用标题来呈现文档结构是很重要的。

应该将 h1 用作主标题（最重要的），其后是 h2（次重要的），再其次是 h3，以此类推



## HTML 注释

```
<!-- 这是一个注释 -->
```



## HTML 链接 - target 属性

1、“_blank”的意思：

浏览器总在一个新打开、未命名的窗口中载入目标文档。

2、“_parent”的意思：

这个目标使得文档载入父窗口或者包含来超链接引用的框架的框架集。如果这个引用是在窗口或者在顶级框架中，那么它与目标 _self 等效。

3、“_self”的意思：

这个目标的值对所有没有指定目标的 <a> 标签是默认目标，它使得目标文档载入并显示在相同的框架或者窗口中作为源文档。这个目标是多余且不必要的，除非和文档标题 <base> 标签中的 target 属性一起使用。

4、“_top”的意思：

这个目标使得文档载入包含这个超链接的窗口，用 _top 目标将会清除所有被包含的框架并将文档载入整个浏览器窗口。

```html
<a href="https://www.runoob.com/" target="_blank" rel="noopener noreferrer">访问菜鸟教程!</a>
```





## HTML样式实例 - 背景颜色

背景色属性（background-color）定义一个元素的背景颜色：

## 

```html
<body style="background-color:yellow;"> 
<h2 style="background-color:red;">这是一个标题</h2>
<p style="background-color:green;">这是一个段落。</p> 
</body>
```





## HTML 样式实例 - 字体, 字体颜色 ，字体大小

我们可以使用font-family（字体），color（颜色），和font-size（字体大小）属性来定义字体的样式:

## 

```html
<h1 style="font-family:verdana;">一个标题</h1>
<p style="font-family:arial;color:red;font-size:20px;">一个段落。</p>
```



## HTML 图像



**<img> 是空标签，意思是说，它只包含属性，并且没有闭合标签。**

**要在页面上显示图像，你需要使用源属性（src）。src 指 "source"。源属性的值是图像的 URL 地址。**

**定义图像的语法是：**

```
<img src="url" alt="some_text">
```

**URL 指存储图像的位置。如果名为 "pulpit.jpg" 的图像位于 www.runoob.com 的 images 目录中，那么其 URL 为 [http://www.runoob.com/images/pulpit.jpg](https://www.runoob.com/images/pulpit.jpg)。**

**浏览器将图像显示在文档中图像标签出现的地方。如果你将图像标签置于两个段落之间，那么浏览器会首先显示第一个段落，然后显示图片，最后显示第二段。**



## HTML 图像- Alt属性

alt 属性用来为图像定义一串预备的可替换的文本。

替换文本属性的值是用户定义的。

<img src="boat.gif" alt="Big Boat">

在浏览器无法载入图像时，替换文本属性告诉读者她们失去的信息。此时，浏览器将显示这个替代性的文本而不是图像。为页面上的图像都加上替换文本属性是个好习惯，这样有助于更好的显示信息，并且对于那些使用纯文本浏览器的人来说是非常有用的。



## HTML 图像- 设置图像的高度与宽度

height（高度） 与 width（宽度）属性用于设置图像的高度与宽度。

属性值默认单位为像素:

```
<img src="pulpit.jpg" alt="Pulpit rock" width="304" height="228">
```

**提示:** 指定图像的高度和宽度是一个很好的习惯。如果图像指定了高度宽度，页面加载时就会保留指定的尺寸。如果没有指定图片的大小，加载页面时有可能会破坏HTML页面的整体布局。



## 基本的注意事项 - 有用的提示：

**注意:** 假如某个 HTML 文件包含十个图像，那么为了正确显示这个页面，需要加载 11 个文件。加载图片是需要时间的，所以我们的建议是：慎用图片。

**注意:** 加载页面时，要注意插入页面图像的路径，如果不能正确设置图像的位置，浏览器无法加载图片，图像标签就会显示一个破碎的图片。



```html
无边框的图片链接:
<a href="//www.runoob.com/html/html-tutorial.html">
<img border="0" src="smiley.gif" alt="HTML 教程" width="32" height="32"></a></p>
```





## HTML 表格表头



**表格的表头使用 <th> 标签进行定义。**

**大多数浏览器会把表头显示为粗体居中的文本：**

### 表格題目  <caption>



```html
<table border="1">
    <caption>Monthly savings</caption>   // 表格題目
    
    <tr>
        <th>Header 1</th>
        <th>Header 2</th>
    </tr>
    <tr>
        <td>row 1, cell 1</td>
        <td>row 1, cell 2</td>
    </tr>
    <tr>
        <td>row 2, cell 1</td>
        <td>row 2, cell 2</td>
    </tr>
</table>
```



 **跨列标签**

```
 <th colspan="2">Telephone</th>  // 跨列标签
```

**跨行标签**

```
 <th rowspan="2">Telephone:</th> //跨行标签
```



## HTML 表单 - 输入元素



#### 单选按钮（Radio Buttons）

```
<input type="radio" name="sex" value="male">Male<br>
<input type="radio" name="sex" value="female">Female
```





#### 复选框（Checkboxes）

```
<input type="checkbox" name="vehicle" value="Bike">I have a bike<br>
<input type="checkbox" name="vehicle" value="Car">I have a car 
```



#### 下拉列表

```
<select name="cars">
<option value="volvo">Volvo</option>
<option value="saab">Saab</option>
<option value="fiat">Fiat</option>
<option value="audi">Audi</option>
</select>
```



#### 单选框

```
 <input type="radio" name="sex" value="Male"> Male<br>
  <input type="radio" name="sex" value="Female" checked="checked"> Female<br>
```







**总结：**

```

<input type="reset">定义重置按钮

<input type="reset" name="button" id="button" value="重置">

点击之后会将重置按钮所在的表单中填写的内容重新设置为默认值
```





## URL - 统一资源定位器

- scheme - 定义因特网服务的类型。最常见的类型是 http
- host - 定义域主机（http 的默认主机是 www）
- domain - 定义因特网域名，比如 runoob.com
- :port - 定义主机上的端口号（http 的默认端口号是 80）
- path - 定义服务器上的路径（如果省略，则文档必须位于网站的根目录中）。
- filename - 定义文档/资源的名称