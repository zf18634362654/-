**DOM**

## HTML DOM（文档对象模型）

当网页被加载时，浏览器会创建页面的文档对象模型（*D*ocument *O*bject *M*odel）。

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

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>w </title>
    <script>
        function  change() {
          document.write("卧槽");
        }

    </script>
</head>
<body >
<p>我啊</p>
<button onclick="change()">我</button>

</body>
</html>
```

![image-20191126180414593](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191126180414593.png)

![image-20191126180423044](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191126180423044.png)点击按钮前后效果

# JavaScript - HTML DOM 方法



**HTML DOM 方法是您能够（在 HTML 元素上）执行的动作。**

**HTML DOM 属性是您能够设置或改变的 HTML 元素的值。**

## DOM 编程界面

HTML DOM 能够通过 JavaScript 进行访问（也可以通过其他编程语言）。

在 DOM 中，所有 HTML 元素都被定义为*对象*。

编程界面是每个对象的属性和方法。

*属性*是您能够获取或设置的值（就比如改变 HTML 元素的内容）。

*方法*是您能够完成的动作（比如添加或删除 HTML 元素）。

## getElementById 方法

访问 HTML 元素最常用的方法是使用元素的 id。

在上面的例子中，getElementById 方法使用 id="demo" 来查找元素。

## innerHTML 属性

获取元素内容最简单的方法是使用 innerHTML 属性。

innerHTML 属性可用于获取或替换 HTML 元素的内容。

innerHTML 属性可用于获取或改变任何 HTML 元素，包括 <html> 和 <body>。