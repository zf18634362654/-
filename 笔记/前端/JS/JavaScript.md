

# JavaScript

## **JavaScript 不提供任何内建的打印或显示函数。**

### JavaScript 显示方案

JavaScript 能够以不同方式“显示”数据：

- 使用 window.alert() 写入警告框
- 使用 document.write() 写入 HTML 输出
- 使用 innerHTML 写入 HTML 元素
- 使用 console.log() 写入浏览器控制台

### 使用 innerHTML

如需访问 HTML 元素，JavaScript 可使用 document.getElementById(id) 方法。

id 属性定义 HTML 元素。innerHTML 属性定义 HTML 内容：

 **提示：**更改 HTML 元素的 innerHTML 属性是在 HTML 中显示数据的常用方法 

 **注意：**在 HTML 文档完全加载后使用 **document.write()** 将*删除所有已有的 HTML*  

 **document.write()** 方法仅用于测试 

### 使用 console.log()

在浏览器中，您可使用 console.log() 方法来显示数据。

请通过 F12 来激活浏览器控制台，并在菜单中选择“控制台”。



JavaScript 与驼峰式大小写

历史上，程序员曾使用三种把多个单词连接为一个变量名的方法：

连字符：

```
first-name, last-name, master-card, inter-city.
```

**注释：**JavaScript 中不能使用连字符。它是为减法预留的。

## JavaScript 数据类型

### JavaScript 拥有动态类型。这意味着相同变量可用作不同类型：

```javascript
var x;               // 现在 x 是 undefined
var x = 7;           // 现在 x 是数值
var x = "Bill";      // 现在 x 是字符串值
```



### 数字均为number类型

### JavaScript 对象（JS中对象不可以做比较）

JavaScript 对象用花括号来书写。

对象属性是 *name*:*value* 对，由逗号分隔。

**直接输出对象时 返回的时Object**

```javascript
var person = {
  firstName: "Bill",
  lastName : "Gates",
  id       : 678,
  fullName : function() {
    return this.firstName + " " + this.lastName;
  }
};//调用方法时 只需 person.fullName()
```

**访问对象属性**

您能够以两种方式访问属性：

```
objectName.propertyName
```

或者

```
objectName["propertyName"]   //注意双引号
```



### JavaScript 数组

JavaScript 数组用方括号书写。

数组的项目由逗号分隔。

下面的代码声明（创建）了名为 cars 的数组，包含三个项目（汽车品牌）：

### 

```
var cars = ["Porsche", "Volvo", "BMW"];
```

**注意： 任何变量均可通过设置值为 undefined 进行清空。其类型也将是 undefined。** 





### Null

在 JavaScript 中，null 是 "nothing"。它被看做不存在的事物。

不幸的是，在 JavaScript 中，null 的数据类型是对象。

您可以把 null 在 JavaScript 中是对象理解为一个 bug。它本应是 null。

您可以通过设置值为 null 清空对象： 也可以通过设置值为 undefined 清空对象： 但对象类型会不同

### Null与undefined

Undefined 与 null 的值相等，但类型不相等：

```javascript
typeof undefined              // undefined
typeof null                   // object
null === undefined            // false
null == undefined             // true
```

### 复杂数据

typeof 运算符可返回以下两种类型之一：

- function
- object

typeof 运算符把对象、数组或 null 返回 object。

typeof 运算符不会把函数返回 object。

#### 有关函数的

```javascript
typeof function myFunc(){}+ //function
typeof a;//function
  a;//返回函数定义
function a(){
alert(123);
}
```

调用函数时 不加()会返回函数定义

#### 函数调用

函数中的代码将在其他代码调用该函数时执行：

- 当事件发生时（当用户点击按钮时）
- 当 JavaScript 代码调用时
- 自动的（自调用）





## 有关事件

| 事件        | 描述                         |
| :---------- | :--------------------------- |
| onchange    | HTML 元素已被改变            |
| onclick     | 用户点击了 HTML 元素         |
| onmouseover | 用户把鼠标移动到 HTML 元素上 |
| onmouseout  | 用户把鼠标移开 HTML 元素     |
| onkeydown   | 用户按下键盘按键             |
| onload      | 浏览器已经完成页面加载       |





## 有关String

 **内建属性 length 可返回字符串的*长度***     类似于Java数组中的属性  但在Java中String中 length是方法

转义表

| 代码 | 结果 | 描述   |
| :--- | :--- | :----- |
| \'   | '    | 单引号 |
| \"   | "    | 双引号 |
| \\   | \    | 反斜杠 |



| b    | 退格键     |
| ---- | ---------- |
| \f   | 换页       |
| \n   | 新行       |
| \r   | 回车       |
| \t   | 水平制表符 |
| \v   | 垂直制表符 |

**请不要把字符串创建为对象。它会拖慢执行速度。**

**new 关键字使代码复杂化。也可能产生一些意想不到的结果：**

**当使用 == 相等运算符时，相等字符串是相等的：**

```javascript
var x = "Bill";
var y = new String("Bill");

// typeof x 将返回 string
// typeof y 将返回 object
```

```
var x = "Bill";             
var y = new String("Bill");

// (x == y) 为 true，因为 x 和 y 的值相等
```

 **当使用 === 运算符时，相等字符串是不相等的，因为 === 运算符需要类型和值同时相等。** 

```javascript
var x = "Bill";             
var y = new String("Bill");

// (x === y) 为 false，因为 x 和 y 的类型不同（字符串与对象）
```

甚至更糟。对象无法比较：

### 

```javascript
var x = new String("Bill");             
var y = new String("Bill");

// (x == y) 为 false，因为 x 和 y 是不同的对象
```

### 检索字符串中的字符串

search() 方法搜索特定值的字符串，并返回匹配的位置：





### 查找字符串中的字符串

indexOf() 方法返回字符串中指定文本*首次*出现的索引（位置）



 **如果未找到文本， indexOf() 和 lastIndexOf() 均返回 -1。** 

indexOf() 与 search()，是*相等的*。

这两种方法是不相等的。区别在于：

- search() 方法无法设置第二个开始位置参数。
- indexOf() 方法无法设置更强大的搜索值（正则表达式）

**slice()**

**substring()**

**substr()**

**三者不同**：ubstring() 类似于 slice()。

不同之处在于 substring() 无法接受负的索引。

2.substr() 类似于 slice()。

不同之处在于第二个参数规定被提取部分的*长度*。

 **concat()** 方法可用于代替加运算符。下面两行是等效的 

```
var text = "Hello" + " " + "World!";
var text = "Hello".concat(" ","World!");
```

所有字符串方法都会返回新字符串。它们不会修改原始字符串。

正式地说：字符串是不可变的：字符串不能更改，只能替换。

**String.trim()**

trim() 方法删除字符串两端的空白符：





### 把字符串转换为数组

可以通过 split() 将字符串转换为数组：

### 

```
var txt = "a,b,c,d,e";   // 字符串
txt.split(",");          // 用逗号分隔
txt.split(" ");          // 用空格分隔
txt.split("|");          // 用竖线分隔
```





## 有关数字

### NaN - 非数值

NaN 属于 JavaScript 保留词，指示某个数不是合法数。

尝试用一个非数字字符串进行除法会得到 NaN（Not a Number）：

### 

```javascript
var x = 100 / "Apple";  // x 将是 NaN（Not a Number）
typeof NaN;             // 返回 "number"
typeof Infinity;        // 返回 "number"
```

 **您可使用全局 JavaScript 函数 isNaN() 来确定某个值是否是数** 





### Infinity

Infinity （或 -Infinity）是 JavaScript 在计算数时超出最大可能数范围时返回的值。

 **除以 0（零）也会生成 Infinity：** 

**但是您能够使用 toString() 方法把数输出为十六进制、八进制或二进制。**

### 

```
var myNumber = 128;
myNumber.toString(16);     // 返回 80
myNumber.toString(8);      // 返回 200
myNumber.toString(2);      // 返回 10000000
```

请不要创建数值对象。这样会拖慢执行速度。

new 关键词使代码复杂化，并产生某些无法预料的结果：

当使用 == 相等运算符时，相等的数看上去相等：





### Number 方法和属性

原始值（比如 3.14 或 2016），无法拥有属性和方法（因为它们不是对象）。

但是通过 JavaScript，方法和属性也可用于原始值，因为 JavaScript 在执行方法和属性时将原始值视作对象。

#### toString() 方法

toString() 以字符串返回数值。

#### valueOf() 方法

valueOf() 以数值返回数值：



在 JavaScript 中，数字可以是原始值（typeof = number）或对象（typeof = object）。

在 JavaScript 内部使用 valueOf() 方法可将 Number 对象转换为原始值。

没有理由在代码中使用它。

所有 JavaScript 数据类型都有 valueOf() 和 toString() 方法。





## 全局方法



JavaScript 全局方法可用于所有 JavaScript 数据类型。

这些是在处理数字时最相关的方法：

| 方法         | 描述                         |
| :----------- | :--------------------------- |
| Number()     | 返回数字，由其参数转换而来。 |
| parseFloat() | 解析其参数并返回浮点数。     |
| parseInt()   | 解析其参数并返回整数。       |

#### Number() 方法

Number() 可用于把 JavaScript 变量转换为数值   如果无法转换数字，则返回 NaN。 

```javascript
x = true;
Number(x);        // 返回 1
x = false;     
Number(x);        // 返回 0
x = new Date();
Number(x);        // 返回 1404568027739
x = "10"
Number(x);        // 返回 10
x = "10 20"
Number(x);        // 返回 NaN
```

#### parseInt() 方法

parseInt() 解析一段字符串并返回数值。允许空格。只返回首个数字：

### 

```
parseInt("10");         // 返回 10
parseInt("10.33");      // 返回 10
parseInt("10 20 30");   // 返回 10
parseInt("10 years");   // 返回 10
parseInt("years 10");   // 返回 NaN
```

#### Ja MIN_VALUE 和 MAX_VALUE

MAX_VALUE 返回 JavaScript 中可能的最大数字。





#### 数字属性不可用于变量

数字属性属于名为 number 的 JavaScript 数字对象包装器。

这些属性只能作为 Number.MAX_VALUE 访问。

使用 myNumber.MAX_VALUE，其中 myNumber 是变量、表达式或值，将返回 undefined：

### 

```javascript
var x = 6;
var y = x.MAX_VALUE;    // y 成为 undefined
```

