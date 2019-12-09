

# CSS

CSS 规则由两个主要的部分构成：选择器，以及一条或多条声明:

![img](https://www.runoob.com/wp-content/uploads/2013/07/632877C9-2462-41D6-BD0E-F7317E4C42AC.jpg)

选择器通常是您需要改变样式的 HTML 元素。

每条声明由一个属性和一个值组成。

属性（property）是您希望设置的样式属性（style attribute）。每个属性有一个值。属性和值被冒号分开。

## CSS 注释

CSS注释以 "/*" 开始, 以 "*/" 结束, 实例如下:

```css
/*这是个注释*/
p
{
text-align:center;
/*这是另一个注释*/
color:black;
font-family:arial;
}
```



## CSS Id 和 Class



### id 选择器

id 选择器可以为标有特定 id 的 HTML 元素指定特定的样式。

HTML元素以id属性来设置id选择器,CSS 中 id 选择器以 "#" 来定义。

以下的样式规则应用于元素属性 id="para1":

## 

```css
#para1 {    text-align:center;    color:red; }
```

提**示：  ID属性不要以数字开头，数字开头的ID在 Mozilla/Firefox 浏览器中不起作用。** 





### class 选择器

class 选择器用于描述一组元素的样式，class 选择器有别于id选择器，class可以在多个元素中使用。

class 选择器在HTML中以class属性表示, 在 CSS 中，类选择器以一个点"."号显示：

在以下的例子中，所有拥有 center 类的 HTML 元素均为居中。

## 

```
.center {text-align:center;}
```



**你也可以指定特定的HTML元素使用class。**

**在以下实例中, 所有的 p 元素使用 class="center" 让该元素的文本居中:**

## 

```
p.center {text-align:center;}
```

 **类名的第一个字符不能使用数字！它无法在 Mozilla 或 Firefox 中起作用** 





### 标签选择器



即以 html 标签作为 css 修饰所用的选择器。



```
<style>
h3{
    color:red;
}
</style>
<h3>菜鸟教程</h3>
```





### 包含选择器：

包含选择器除了有 **A B{...}** 的形式外（A和B都是标签），还可以有这种形式：**.A B{...}** 的形式（A是类名，B是标签）。

作用与上面介绍的相同，会使 class 名为 A 的标签里面所有名为 B 的子代标签的内容按照设定的内容显示。

```
<style>
.first span{
  color:red;
}
</style>
<body>
<p class="first"><span>内容为红色</span>
<ol>
  <li><span>内容也是红色</span></li>
  <li><span>内容也是红色</span></li>
</ol></p>

</body>
```



### 子选择器

子选择器除了有 **A >B{...}** 的形式外（A和B都是标签），还可以有这种形式：**.A >B{...}** 的形式（A是类名，B是标签）。

作用与上面介绍的相同，会使 class 为 A 的标签里面所有名为 B 的直接子代标签的内容按照设定的内容显示。而非直接子代的 B 标签的内容是不会改变的。

```
<style>
.first>span{
  color:red;
}
</style>
<body>
<p class="first"><span>内容为红色</span>
<ol>
  <li><span>内容不是红色</span></li>
  <li><span>内容不是红色</span></li>
</ol></p>

</body>
```



## CSS 背景



CSS 属性定义背景效果:

- background-color
- background-image
- background-repeat
- background-attachment
- background-position



## CSS 盒子模型(Box Model)

所有HTML元素可以看作盒子，在CSS中，"box model"这一术语是用来设计和布局时使用。

CSS盒模型本质上是一个盒子，封装周围的HTML元素，它包括：边距，边框，填充，和实际内容。

盒模型允许我们在其它元素和周围元素边框之间的空间放置元素。

下面的图片说明了盒子模型(Box Model)：


![CSS box-model](https://www.runoob.com/images/box-model.gif)

- **Margin(外边距)** - 清除边框外的区域，外边距是透明的。
- **Border(边框)** - 围绕在内边距和内容外的边框。
- **Padding(内边距)** - 清除内容周围的区域，内边距是透明的。
- **Content(内容)** - 盒子的内容，显示文本和图像。

## 背景图像 - 水平或垂直平铺











# Bootstrap 插件概览



- ****单独引用：使用 Bootstrap 的个别的 **.js* 文件。一些插件和 CSS 组件依赖于其他插件。如果您单独引用插件，请先确保弄清这些插件之间的依赖关系。**

- **编译（同时）引用**

  **：使用**

  ****

  **bootstrap.js**

  ****

  **或压缩版的**

  ****

  **bootstrap.min.js**

  **。**

  > **![img](https://www.runoob.com/images/quote.png)不要尝试同时引用这两个文件，因为 *bootstrap.js* 和 *bootstrap.min.js* 都包含了所有的插件。**

***所有的插件依赖于 jQuery。所以**必须在插件文件之前引用 jQuery。*

## data 属性

- 你可以仅仅通过 data 属性 API 就能使用所有的 Bootstrap 插件，无需写一行 JavaScript 代码。这是 Bootstrap 中的一等 API，也应该是你的首选方式。

- 话又说回来，在某些情况下可能需要将此功能关闭。因此，我们还提供了关闭 data 属性 API 的方法，即解除以

   

  data-api

   

  为命名空间并绑定在文档上的事件。就像下面这样：

  ```
  $(document).off('.data-api')
  ```

- 如需关闭一个特定的插件，只需要在 data-api 命名空间前加上该插件的名称作为命名空间即可，如下所示：

  ```
  $(document).off('.alert.data-api')
  ```

