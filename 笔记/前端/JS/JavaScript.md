

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

#### JS MIN_VALUE 和 MAX_VALUE

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

## 有关数组

 数组是一种特殊类型的对象。在 JavaScript 中对数组使用 typeof 运算符会返回 "object" 

 正因如此，您可以在相同数组中存放不同类型的变量。 





### length 属性

length 属性返回数组的长度（数组元素的数目）。

### 遍历数组元素

1.传统遍历

2.forEach()遍历  (与Java中不同)

```javascript
var fruits, text;
fruits = ["Banana", "Orange", "Apple", "Mango"];

text = "<ul>";
fruits.forEach(myFunction);
text += "</ul>";

function myFunction(value) {
  text += "<li>" + value + "</li>";
}
```

### 添加数组元素

 向数组添加新元素的最佳方法是使用 push() 方法： 

```javascript
var fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.push("Lemon");                // 向 fruits 添加一个新元素 (Lemon)
```

也可以使用 length 属性向数组添加新元素：

### 

```javascript
var fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits[fruits.length] = "Lemon";     // 向 fruits 添加一个新元素 (Lemon)
```





### 把数组转换为字符串

JavaScript 方法 toString() 把数组转换为数组值（逗号分隔）的字符串。





### Popping 和 Pushing   

在处理数组时，删除元素和添加新元素是很简单的。

Popping 和 Pushing 指的是：

从数组*弹出*项目，或向数组*推入*项目（都是操作数组最后一个元素）。

 pop() 方法返回“被弹出”的值 

 push() 方法返回新数组的长度： 





### 位移元素

**位移与弹出等同，但处理首个元素而不是最后一个。**

shift() 方法会删除首个数组元素，并把所有其他元素“位移”到更低的索引

 shift() 方法返回被“位移出”的字符串： 

 unshift() 方法（在开头）向数组添加新元素，并“反向位移”旧元素： 

 **使用 delete 会在数组留下未定义的空洞** （被删除的位置 undefined）





### 使用 splice() 来删除元素

通过**聪明**的参数设定，您能够使用 splice() 在数组中不留“空洞”的情况下移除元素：

### 

```
var fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.splice(0, 1);        // 删除 fruits 中的第一个元素
```



**第一个参数（0）定义新元素应该被*添加*（接入）的位置。**

**第二个参数（1）定义应该*删除多个*元素。**

其余参数被省略。没有新元素将被添加。





### 合并（连接）数组

concat() 方法通过合并（连接）现有数组来创建一个新数组：

```
var myGirls = ["Cecilie", "Lone"];
var myBoys = ["Emil", "Tobias", "Linus"];
var myChildren = myGirls.concat(myBoys);   // 连接 myGirls 和 myBoys
```





### 数组排序

 **sort() 方法是最强大的数组方法之一** (由小到大)

 **sort() 方法以字母顺序对数组进行排序** 

```javascript
var fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.sort();            // 对 fruits 中的元素进行排序  //Apple,Banana,Mango,Orange
```

#### 反转数组

reverse() 方法反转数组中的元素， 您可以使用它以降序对数组进行排序： 

```javascript
var fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.sort();            // 对 fruits 中的元素进行排序
fruits.reverse();         // 反转元素顺序
```

 

#### 数字数组排序需要在sort（）中加入比较函数

比较函数的目的是定义另一种排序顺序。

比较函数应该返回一个负，零或正值，这取决于参数：

```
function(a, b){return a-b}
```

当 sort() 函数比较两个值时，会将值发送到比较函数，并根据所返回的值（负、零或正值）对这些值进行排序。

```javascript
  var  array=[10,4,5,3,23];
  alert(array.sort(function(a, b){return b - a}));//降序
```





#### 排序对象数组

JavaScript 数组经常会包含对象：

### 

```
var cars = [
{type:"Volvo", year:2016},
{type:"Saab", year:2001},
{type:"BMW", year:2010}];
```

即使对象拥有不同数据类型的属性，sort() 方法仍可用于对数组进行排序。

解决方法是通过比较函数来对比属性值：

### 

```
cars.sort(function(a, b){return a.year - b.year});
```

**比较对象的字符串属性会稍复杂：**

### 

```Java
cars.sort(function(a, b){
	  var x = a.type.toLowerCase();
	  var y = b.type.toLowerCase();
	  if (x < y) {return -1;}
	  if (x > y) {return 1;}             //可等价为  return x-y
	  return 0;
});
```




### 数组迭代

#### Array.forEach()

**forEach() 方法为每个数组元素调用一次函数（回调函数）。**

```javascript
var txt = "";
var numbers = [45, 4, 9, 16, 25];
numbers.forEach(myFunction);

function myFunction(value, index, array) {
  txt = txt + value + "<br>"; 
}
```

**注释：**该函数接受 3 个参数：

- 项目值
- 项目索引
- 数组本身

上面的例子只用了 value 参数





#### Array.map()

map() 方法通过对每个数组元素执行函数来创建新数组。

map() 方法不会对没有值的数组元素执行函数。

map() 方法不会更改原始数组。

这个例子将每个数组值乘以2：

```
var numbers1 = [45, 4, 9, 16, 25];
var numbers2 = numbers1.map(myFunction);

function myFunction(value, index, array) {
  return value * 2;
}
```



#### Array.filter()

filter() 方法创建一个包含通过测试的数组元素的新数组。

这个例子用值大于 18 的元素创建一个新数组

```
var numbers = [45, 4, 9, 16, 25];
var over18 = numbers.filter(myFunction);

function myFunction(value, index, array) {
  return value > 18;
}
```





#### Array.reduce()

reduce() 方法在每个数组元素上运行函数，以生成（减少它）单个值。

reduce() 方法在数组中从左到右工作。另请参见 reduceRight（）。

reduce() 方法不会减少原始数组。

这个例子确定数组中所有数字的总和：

 **reduce() 方法能够接受一个初始值** 

```javascript
var numbers1 = [45, 4, 9, 16, 25];
var sum = numbers1.reduce(myFunction);

function myFunction(total, value, index, array) {
  return total + value;
}
```

请注意此函数接受 4 个参数：

- 总数（初始值/先前返回的值）
- 项目值
- 项目索引
- 数组本身

上例并未使用 index 和 array 参数



#### Array.every()

every() 方法检查所有数组值是否通过测试。

这个例子检查所有数组值是否大于 18：

### 

```
var numbers = [45, 4, 9, 16, 25];
var allOver18 = numbers.every(myFunction);

function myFunction(value, index, array) {
  return value > 18;
}
```

#### Array.some()

some() 方法检查某些数组值是否通过了测试。

这个例子检查某些数组值是否大于 18：

### 

```javascript
var numbers = [45, 4, 9, 16, 25];
var someOver18 = numbers.some(myFunction);

function myFunction(value, index, array) {
  return value > 18;
}
```

## 特殊的Boolean

**负数和对象(存在的) 均为true**

## 所有不具有“真实”值的即为 False

*0（零）*的布尔值为 *false*：

```
var x = 0;
Boolean(x);       // 返回 false
```



*-0 （负零）*的布尔值为 *false*：

```
var x = -0;
Boolean(x);       // 返回 false
```



*""（空值）*的布尔值为 *false*：

```
var x = "";
Boolean(x);       // 返回 false
```



*undefined* 的布尔值是 *false*：

```
var x;
Boolean(x);       // 返回 false
```



*null* 的布尔值是 *false*：

```
var x = null;
Boolean(x);       // 返回 false
```



*false* 的布尔值（正如您猜到的）是 *false*：

```
var x = false;
Boolean(x);       // 返回 false
```



*NaN* 的布尔值是 *false*：

```
var x = 10 / "H";
Boolean(x);       // 返回 false
```

## 

## 不同类型的循环

JavaScript 支持不同类型的循环：

- for - 多次遍历代码块
- for/in - 遍历对象属性
- while - 当指定条件为 true 时循环一段代码块
- do/while - 当指定条件为 true 时循环一段代码块

### For/In 循环

JavaScript for/in 语句遍历对象的属性：

```javascript
var person = {fname:"Bill", lname:"Gates", age:62}; 

var text = "";
var x;
for (x in person) {
    text += person[x];
}
```

## constructor 属性

 constructor 属性返回所有 JavaScript 变量的构造器函数。 

```javascript
"Bill".constructor                 // 返回 "function String()  { [native code] }"
(3.14).constructor                 // 返回 "function Number()  { [native code] }"
false.constructor                  // 返回 "function Boolean() { [native code] }"
[1,2,3,4].constructor              // 返回 "function Array()   { [native code] }"
{name:'Bill', age:62}.constructor  // 返回" function Object()  { [native code] }"
new Date().constructor             // 返回 "function Date()    { [native code] }"
function () {}.constructor         // 返回 "function Function(){ [native code] }"
```

可以通过检查 constructor 属性来确定某个对象是否为数组（包含单词 "Array"）：

### 

```
function isArray(myArray) {
    return myArray.constructor.toString().indexOf("Array") > -1;
}
```



或者更简单，您可以检查对象是否是数组函数：

```
function isArray(myArray) {
    return myArray.constructor === Array;
}
```



## JS中的正则校验

### 使用字符串方法

在 JavaScript 中，正则表达式常用于两个*字符串方法*：search() 和 replace()。

**search()** 方法使用表达式来搜索匹配，然后返回匹配的位置。

**replace()** 方法返回模式被替换处修改后的字符串。

两种方法都可加入正则表达式

#### 正则表达式修饰符

*修饰符*可用于大小写不敏感的更全局的搜素：

| 修饰符 | 描述                                                     |
| :----- | :------------------------------------------------------- |
| i      | 执行对大小写不敏感的匹配。                               |
| g      | 执行全局匹配（查找所有匹配而非在找到第一个匹配后停止）。 |
| m      | 执行多行匹配。                                           |



### 在字符串方法 search() 中使用正则表达式

### 

使用正则表达式执行搜索字符串中 "w3school" 的大小写不敏感的搜索：

```javascript
var str = "Visit W3School";
var n = str.search(/w3school/i);   //n=6
```

#### test()

test() 是一个正则表达式方法。

它通过模式来搜索字符串，然后根据结果返回 true 或 false。

下面的例子搜索字符串中的字符 "e"：

### 

```
var patt = /e/;
patt.test("The best things in life are free!"); //true
```

#### 使用 exec()

exec() 方法是一个正则表达式方法。

它通过指定的模式（pattern）搜索字符串，并返回已找到的文本。

如果未找到匹配，则返回 null。

下面的例子搜索字符串中的字符 "e"：

### 

```javascript
/e/.exec("The best things in life are free!"); //e
```





## Error 对象

JavaScript 拥有当错误发生时提供错误信息的内置 error 对象。

error 对象提供两个有用的属性：name 和 message。





## JavaScript 提升（Hoisting）

在 JavaScript 中，可以在使用变量之后对其进行声明。

换句话说，可以在声明变量之前使用它。

例子 1 与例子 2 的结果相同：

例子 1

```
x = 5; // 把 5 赋值给 x
 
elem = document.getElementById("demo"); // 查找元素
elem.innerHTML = x;                     // 在元素中显示 x

var x; // 声明 x
```





例子 2

```
var x; // 声明 x
x = 5; // 把 5 赋值给 x

elem = document.getElementById("demo"); // 查找元素
elem.innerHTML = x;                     // 在元素中显示 x
```

 **Hoisting 是 JavaScript 将所有声明提升到当前作用域顶部的默认行为（提升到当前脚本或当前函数的顶部）。** 





## JavaScript 初始化不会被提升

JavaScript 只提升声明，而非初始化。

例子 1 与例子 2 的结果不相同：

例子 1

```
var x = 5; // 初始化 x
var y = 7; // 初始化 y

elem = document.getElementById("demo"); // 查找元素
elem.innerHTML = x + " " + y;           // 显示 x 和 y
```



例子 2

```
var x = 5; // 初始化 x
 
elem = document.getElementById("demo"); // 查找元素
elem.innerHTML = x + " " + y;           // 显示 x 和 y
 
var y = 7; // 初始化 y 
```

## 声明严格模式

通过在脚本或函数的开头添加 "use strict"; 来声明严格模式。

在脚本开头进行声明，拥有全局作用域（脚本中的所有代码均以严格模式来执行）：

严格模式起因：JS中自动将未声明的变量转换为全局变量

```
"use strict";
x = 3.14;       // 这会引发错误，因为 x 尚未声明
```





## this 是什么？

JavaScript this 关键词指的是它所属的对象。

它拥有不同的值，具体取决于它的使用位置：

- 在方法中，this 指的是所有者对象。
- 单独的情况下，this 指的是全局对象。
- 在函数中，this 指的是全局对象。
- 在函数中，严格模式下，this 是 undefined。
- 在事件中，this 指的是接收事件的元素。





## debugger 关键词

*debugger* 关键词会停止 JavaScript 的执行，并调用（如果有）调试函数。

这与在调试器中设置断点的功能是一样的。

如果调试器不可用，debugger 语句没有效果。

如果调试器已打开，此代码会在执行第三行之前停止运行





## 对 JavaScript 字符串换行

JavaScript 允许您把一条语句换行为两行：

例子 1

```
var x =
"Hello World!";
```





但是，在字符串中间来换行是不对的：

例子 2

```
var x = "Hello
World!";
```





如果必须在字符串中换行，则必须使用反斜杠：

例子 3

```
var x = "Hello \
World!";
```

##  JSON 不允许尾随逗号。 





## 易错点

### 如果进行数学运算，JavaScript 能够将数值转换为字符串：

### 

```javascript
var x = 5 + 7;       // x.valueOf() 是 12,  typeof x 是数值
var x = 5 + "7";     // x.valueOf() 是 57,  typeof x 是字符串
var x = "5" + 7;     // x.valueOf() 是 57,  typeof x 是字符串
var x = 5 - 7;       // x.valueOf() 是 -2,  typeof x 是数值
var x = 5 - "7";     // x.valueOf() 是 -2,  typeof x 是数值
var x = "5" - 7;     // x.valueOf() 是 -2,  typeof x 是数值
var x = 5 - "x";     // x.valueOf() 是 NaN, typeof x 是数值
```

**用字符串减去字符串，不会产生错误而是返回 NaN（Not a Number）**：



### 使用 === 比较

== 比较运算符总是在比较之前进行类型转换（以匹配类型）。

=== 运算符会强制对值和类型进行比较：





```javascript
0 == "";        // true
1 == "1";       // true
1 == true;      // true

0 === "";       // false
1 === "1";      // false
1 === true;     // false
```

### 期望块级范围

JavaScript *不会*为每个代码块创建新的作用域。

很多编程语言都是如此，但是 JavaScript *并非如此*。

认为这段代码会返回 undefined，是新的 JavaScript 开发者的常见错误：

### 

```
for (var i = 0; i < 10; i++) {
  // 代码块
}
return i;
```





## JavaScript 性能

### 减少 DOM 访问

与其他 JavaScript 相比，访问 HTML DOM 非常缓慢。

假如您期望访问某个 DOM 元素若干次，那么只访问一次，并把它作为本地变量来使用：



### 缩减 DOM 规模

请尽量保持 HTML DOM 中较少的元素数量。

这么做总是会提高页面加载，并加快渲染（页面显示），尤其是在较小的设备上。

每一次试图搜索 DOM（比如 getElementsByTagName）都将受益于一个较小的 DOM。

## 

### 避免不必要的变量

请不要创建不打算存储值的新变量。

通常您可以替换代码：

```
var fullName = firstName + " " + lastName;
document.getElementById("demo").innerHTML = fullName; 
```

用这段代码：

```
document.getElementById("demo").innerHTML = firstName + " " + lastName
```



### 延迟 JavaScript 加载

请把脚本放在页面底部，使浏览器首先加载页面。

脚本在下载时，浏览器不会启动任何其他的下载。此外所有解析和渲染活动都可能会被阻塞。

HTTP 规范定义浏览器不应该并行下载超过两种要素。

一个选项是在 script 标签中使用 defer="true"。defer 属性规定了脚本应该在页面完成解析后执行，但它只适用于外部脚本。

如果可能，您可以在页面完成加载后，通过代码向页面添加脚本：





## 有关JSON

 **J**ava**S**cript **O**bject **N**otation 

**JSON 是存储和传输数据的格式。**

**JSON 经常在数据从服务器发送到网页时使用**

 JSON 格式是纯文本。读取和生成 JSON 数据的代码可以在任何编程语言编写的。 



## JSON 数据 - 名称和值

JSON 数据的书写方式是名称/值对，类似 JavaScript 对象属性。

名称/值对由（双引号中的）字段名构成，其后是冒号，再其后是值：

```
"firstName":"Bill"
```

**JSON 名称需要双引号。JavaScript 名称不需要。**





#### 把 JSON 文本转换为 JavaScript 对象

JSON 的通常用法是从 web 服务器读取数据，然后在网页中显示数据。

为了简单起见，可以使用字符串作为输入演示。

首先，创建包含 JSON 语法的 JavaScript 字符串：

```
var text = '{ "employees" : [' +
'{ "firstName":"Bill" , "lastName":"Gates" },' +
'{ "firstName":"Steve" , "lastName":"Jobs" },' +
'{ "firstName":"Alan" , "lastName":"Turing" } ]}';
```

然后，使用 JavaScript 的内建函数 JSON.parse() 来把这个字符串转换为 JavaScript 对象：

```
var obj = JSON.parse(text);
```

最后，请在您的页面中使用这个新的 JavaScript 对象：



## JavaScript 表单





HTML 表单验证能够被浏览器自动执行：

如果表单字段（fname）是空的，*required* 属性防止表单被提交：

### HTML 表单实例

```html
<form action="/action_page_post.php" method="post">
   <input type="text" name="fname" required>
   <input type="submit" value="Submit">
</form>
```



### 数据验证

数据验证指的是确保干净、正确和有用的用户输入的过程。

典型的验证任务是：

- 用户是否已填写所有必需的字段？
- 用户是否已输入有效的日期？
- 用户是否在数字字段中输入了文本？

大多数情况下，数据验证的作用是确保正确的用户输入。

验证可以通过很多不同的方法来定义，并且可以使用很多不同的方法来开发。

*服务器端验证*是由 web 服务器执行的，在输入被送往服务器之后。

*客户端验证*是由 web 浏览器执行的，在输入被送往 web 服务器之前。









## 关于对象



在 JavaScript 中，对象是王。如果您理解了对象，就理解了 JavaScript。

在 JavaScript 中，几乎“所有事物”都是对象。

- 布尔是对象（如果用 *new* 关键词定义）
- 数字是对象（如果用 *new* 关键词定义）
- 字符串是对象（如果用 *new* 关键词定义）
- 日期永远都是对象
- 算术永远都是对象
- 正则表达式永远都是对象
- 数组永远都是对象
- 函数永远都是对象
- 对象永远都是对象

**所有 JavaScript 值，除了原始值，都是对象。**



### JavaScript 原始值

*原始值*指的是没有属性或方法的值。

*原始数据类型*指的是拥有原始值的数据。

JavaScript 定义了 5 种原始数据类型：

- string
- number
- boolean
- null
- undefined

原始值是一成不变的（它们是硬编码的，因此不能改变）。

假设 x = 3.14，您能够改变 x 的值。但是您无法改变 3.14 的值。





### 使用 JavaScript 关键词 new

下面的例子也创建了带有四个属性的新的 JavaScript 对象：

### 

```
var person = new Object();
person.firstName = "Bill";
person.lastName = "Gates";
person.age = 50;
person.eyeColor = "blue"; 
```

JavaScript for...in 语句遍历对象的属性。

### 语法

```
for (variable in object) {
    要执行的代码
}
```

for...in 循环中的代码块会为每个属性执行一次。

循环对象的属性：

### 

```javascript
var person = {fname:"Bill", lname:"Gates", age:62}; 

for (x in person) {   //(x表示属性名)
    txt += person[x];
}
```



### 删除属性

delete 关键词从对象中删除属性：

### 

```javascript
var person = {firstName:"Bill", lastName:"Gates", age:62, eyeColor:"blue"};
delete person.age;   // 或 delete person["age"];
```





delete 关键词会同时删除属性的值和属性本身。

删除完成后，属性在被添加回来之前是无法使用的。

delete 操作符被设计用于对象属性。它对变量或函数没有影响。

**delete 操作符不应被用于预定义的 JavaScript 对象属性。这样做会使应用程序崩溃。**

 **delete 关键词不会删除被继承的属性，但是如果您删除了某个原型属性，则将影响到所有从原型继承的对象** 

### 给对象添加方法

```javascript
var person = {
  firstName: "Bill",
  lastName : "Gates",
  id     : 678,
};
person.name = function() {
  return this.firstName + " " + this.lastName;
};

document.getElementById("demo").innerHTML =
"My friend is " + person.name(); 
```





### 对象访问器

#### JavaScript Getter（get 关键词）

本例使用 lang 属性来获取 language 属性的值。

### 

```
// 创建对象：
var person = {
  firstName: "Bill",
  lastName : "Gates",
  language : "en",
  get lang() {
    return this.language;
  }
};

// 使用 getter 来显示来自对象的数据：
document.getElementById("demo").innerHTML = person.lang;
```



#### JavaScript Setter（set 关键词）

本例使用 lang 属性来设置 language 属性的值。

### 

```
var person = {
  firstName: "Bill",
  lastName : "Gates",
  language : "",
  set lang(lang) {
    this.language = lang;
  }
};

// 使用 setter 来设置对象属性：
person.lang = "en";

// 显示来自对象的数据：
document.getElementById("demo").innerHTML = person.language;
```



### 数据质量

使用 getter 和 setter 时，JavaScript 可以确保更好的数据质量



### 为什么使用 Getter 和 Setter？

- 它提供了更简洁的语法
- 它允许属性和方法的语法相同
- 它可以确保更好的数据质量
- 有利于后台工作

## 对象构造器

```javascript
function Person(first, last, age, eye) {
    this.firstName = first;
    this.lastName = last;
    this.age = age;
    this.eyeColor = eye;
}
```

 用大写首字母对构造器函数命名是个好习惯。 



#### 对象类型（蓝图）（类）

前一章的实例是有限制的。它们只创建单一对象。

有时我们需要创建相同“类型”的许多对象的“*蓝图*”。

创建一种“对象类型”的方法，是使用*对象构造器函数*。

在上面的例子中，*函数 Person()* 就是对象构造器函数。

通过 *new* 关键词调用构造器函数可以创建相同类型的对象：

```
var myFather = new Person("Bill", "Gates", 62, "blue");
var myMother = new Person("Steve", "Jobs", 56, "green");
```



#### 为对象添加属性

为已有的对象添加新属性很简单：

### 

```
myFather.nationality = "English";
```



#### 为对象添加方法

为已有的对象添加新方法很简单：

### 

```
myFather.name = function () {
    return this.firstName + " " + this.lastName;
};
```





## 原型继承

所有 JavaScript 对象都从原型继承属性和方法。

日期对象继承自 Date.prototype。数组对象继承自 Array.prototype。Person 对象继承自 Person.prototype。

Object.prototype 位于原型继承链的顶端：

日期对象、数组对象和 Person 对象都继承自 Object.prototype。





## 向对象添加属性和方法

有时，您希望向所有给定类型的已有对象添加新属性（或方法）。

有时，您希望向对象构造器添加新属性（或方法）。

### 使用 prototype 属性

**给构建器添加属性******类似给所有已有对象添加属性****

JavaScript prototype 属性允许您为对象构造器添加新属性：

### 

```
function Person(first, last, age, eyecolor) {
    this.firstName = first;
    this.lastName = last;
    this.age = age;
    this.eyeColor = eyecolor;
     this.name = function() {return this.firstName + " " + this.lastName;};
}
Person.prototype.nationality = "English";
```



**JavaScript prototype 属性也允许您为对象构造器添加新方法：**

### 

```
function Person(first, last, age, eyecolor) {
    this.firstName = first;
    this.lastName = last;
    this.age = age;
    this.eyeColor = eyecolor;
}
Person.prototype.name = function() {
    return this.firstName + " " + this.lastName;
};
```



## 您知道吗？

**正如以上所见，JavaScript 提供原始数据类型字符串、数字和布尔的对象版本。但是并无理由创建复杂的对象。原始值快得多！**

**请使用对象字面量 {} 代替 new Object()。**

**请使用字符串字面量 "" 代替 new String()。**

**请使用数值字面量代替 Number()。**

**请使用布尔字面量代替 new Boolean()。**

**请使用数组字面量 [] 代替 new Array()。**

**请使用模式字面量代替 new RexExp()。**

**请使用函数表达式 () {} 代替 new Function()。**









## JS有关函数

```
var x = function (a, b) {return a * b};
var z = x(4, 3);   //12
```





上面的函数实际上是一个***匿名函数***（没有名称的函数）。

存放在变量中的函数不需要函数名。他们总是使用变量名调用。

上面的函数使用分号结尾，因为它是可执行语句的一部分。



### Function() 构造器

正如您在之前的例子中看到的，JavaScript 函数是通过 function 关键词定义的。

函数也可以通过名为 Function() 的内建 JavaScript 函数构造器来定义。

### 

```
var myFunction = new Function("a", "b", "return a * b");

var x = myFunction(4, 3);
```





### 函数提升

在本教程中稍早前，您已经学到了“提升”（hoisting）。

Hoisting 是 JavaScript 将*声明*移动到当前作用域顶端的默认行为。

Hoisting 应用于变量声明和函数声明。

正因如此，JavaScript 函数能够在声明之前被调用：

```
myFunction(5);

 function myFunction(y) {
     return y * y;
}
```

**使用表达式定义的函数不会被提升。**



```javascript

// 函数表达式
baz(); // TypeError: baz is not a function
 
var baz = function(){
    console.log(200);
}
 
//相当于
 
var baz;
 
baz();
 
baz = function() {
    console.log(200);

```









### 自调用函数

函数表达式可以作为“自调用”。

自调用表达式是自动被调用（开始）的，在不进行调用的情况下。

函数表达式会自动执行，假如表达式后面跟着 ()。

您无法对函数声明进行自调用。

您需要在函数周围添加括号，以指示它是一个函数表达式：

### 

```
(function () {
    var x = "Hello!!";      //我会调用我自己
})();  //会自动调用
```





## 函数是对象

JavaScript 中的 typeof 运算符会为函数返回 "function"。

但是最好是把 JavaScript 函数描述为对象。

JavaScript 函数都有*属性*和*方法*。

arguments.length 会返回函数被调用时收到的参数数目：

### 

```
function myFunction(a, b) {
    return arguments.length;
}
```





## 函数参数





### 参数规则

JavaScript 函数定义不会为参数（parameter）规定数据类型。

JavaScript 函数不会对所传递的参数（argument）实行类型检查。

JavaScript 函数不会检查所接收参数（argument）的数量。





**如果调用参数时*省略了参数*（少于被声明的数量），则丢失的值被设置为：*undefined*。**

**有时这是可以接受的，但是有时最好给参数指定默认值：**



```javascript
function myFunction(x, y) {
  if (y === undefined) {
    y = 0;
  }  
  return x * y;
}
document.getElementById("demo").innerHTML = myFunction(4); //0
```







### arguments 对象

JavaScript 函数有一个名为 arguments 对象的内置对象。

arguments 对象包含函数调用时使用的参数数组。

这样，您就可以简单地使用函数来查找（例如）数字列表中的最高值：

### 

```
x = findMax(1, 123, 500, 115, 44, 88);

function findMax() {
    var i;
    var max = -Infinity;
    for (i = 0; i < arguments.length; i++) {
        if (arguments[i] > max) {
            max = arguments[i];
        }
    }
    return max;
}
```







## 全局对象

当不带拥有者对象调用对象时，this 的值成为全局对象。

在 web 浏览器中，全局对象就是浏览器对象。

本例以 this 的值返回这个 window 对象：

### 

```
var x = myFunction();            // x 将成为 window 对象

function myFunction() {
   return this;
}
```





调用一个函数作为一个全局函数，会导致 this 的值成为全局对象。

**作为变量来使用 window 对象很容易使程序崩溃。**





### 

# 闭包

**JavaScript 变量属于本地或全局作用域。**

**全局变量能够通过闭包实现局部（私有）。**



**全局访问局部变量**



```javascript
function f1(){

　　　　var n=999;

　　　　nAdd=function(){n+=1}

　　　　function f2(){
　　　　　　alert(n);
　　　　}

　　　　return f2;

　　}

　　var result=f1();

　　result(); // 999

　　nAdd();

　　result(); // 1000
```

