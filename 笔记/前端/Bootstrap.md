# Bootstrap 



## Bootstrap 包的内容

- **基本结构**：Bootstrap 提供了一个带有网格系统、链接样式、背景的基本结构。这将在 **Bootstrap 基本结构** 部分详细讲解。

- **CSS**：Bootstrap 自带以下特性：全局的 CSS 设置、定义基本的 HTML 元素样式、可扩展的 class，以及一个先进的网格系统。这将在 **Bootstrap CSS** 部分详细讲解。

- **组件**：Bootstrap 包含了十几个可重用的组件，用于创建图像、下拉菜单、导航、警告框、弹出框等等。这将在 **布局组件** 部分详细讲解。

- JavaScript 插件

  ：Bootstrap 包含了十几个自定义的 jQuery 插件。您可以直接包含所有的插件，也可以逐个包含这些插件。这将在

   

  Bootstrap 插件

   

  部分详细讲解。

  

- **定制**：您可以定制 Bootstrap 的组件、LESS 变量和 jQuery 插件来得到您自己的版本。





```
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

*width* 属性控制设备的宽度。假设您的网站将被带有不同屏幕分辨率的设备浏览，那么将它设置为 *device-width* 可以确保它能正确呈现在不同设备上。

*initial-scale=1.0* 确保网页加载时，以 1:1 的比例呈现，不会有任何的缩放。



## 响应式图像

```
<img src="..." class="img-responsive" alt="响应式图像">
```

## Bootstrap 表格

Bootstrap 提供了一个清晰的创建表格的布局。下表列出了 Bootstrap 支持的一些表格元素：

| 标签      | 描述                                                         |
| :-------- | :----------------------------------------------------------- |
| <table>   | 为表格添加基础样式。                                         |
| <thead>   | 表格标题行的容器元素（<tr>），用来标识表格列。 第一行的水平线去掉 |
| <tbody>   | 表格主体中的表格行的容器元素（<tr>）。                       |
| <tr>      | 一组出现在单行上的表格单元格的容器元素（<td> 或 <th>）。     |
| <td>      | 默认的表格单元格。                                           |
| <th>      | 特殊的表格单元格，用来标识列或行（取决于范围和位置）。必须在 <thead> 内使用。 |
| <caption> | 关于表格存储内容的描述或总结。  在表格的左上角               |



### 表格类

下表样式可用于表格中：

| 类                   | 描述                                            | 实例                                                         |
| :------------------- | :---------------------------------------------- | :----------------------------------------------------------- |
| .table               | 为任意 <table> 添加基本样式 (只有横向分隔线)    | [尝试一下](https://www.runoob.com/try/try.php?filename=trybs_ref_table&) |
| .table-striped       | 在 <tbody> 内添加斑马线形式的条纹 ( IE8 不支持) | [尝试一下](https://www.runoob.com/try/try.php?filename=trybs_ref_table-striped) |
| .table-bordered      | 为所有表格的单元格添加边框                      | [尝试一下](https://www.runoob.com/try/try.php?filename=trybs_ref_table-bordered) |
| .table-hover         | 在 <tbody> 内的任一行启用鼠标悬停状态           | [尝试一下](https://www.runoob.com/try/try.php?filename=trybs_ref_table-hover) |
| .table-condensed     | 让表格更加紧凑                                  | [尝试一下](https://www.runoob.com/try/try.php?filename=trybs_ref_table-condensed) |
| *联合使用所有表格类* |                                                 | [尝试一下](https://www.runoob.com/try/try.php?filename=trybs_ref_table-all) |







<tr>, <th> 和 <td> 类

下表的类可用于表格的行或者单元格：

| 类       | 描述                             | 实例                                                         |
| :------- | :------------------------------- | :----------------------------------------------------------- |
| .active  | 将悬停的颜色应用在行或者单元格上 | [尝试一下](https://www.runoob.com/try/try.php?filename=trybs_ref_tr_active) |
| .success | 表示成功的操作                   | [尝试一下](https://www.runoob.com/try/try.php?filename=trybs_ref_tr_success) |
| .info    | 表示信息变化的操作               | [尝试一下](https://www.runoob.com/try/try.php?filename=trybs_ref_tr_info) |
| .warning | 表示一个警告的操作               | [尝试一下](https://www.runoob.com/try/try.php?filename=trybs_ref_tr_warning) |
| .danger  | 表示一个危险的操作               | [尝试一下](https://www.runoob.com/try/try.php?filename=trybs_ref_tr_danger) |



## 响应式表格

通过把任意的 *.table* 包在 *.table-responsive* class 内，您可以让表格水平滚动以适应小型设备（小于 768px）。当在大于 768px 宽的大型设备上查看时，您将看不到任何的差别。

## 

<div class="table-responsive">   <table class="table">     <caption>响应式表格布局</caption>     <thead>       <tr>         <th>产品</th>         <th>付款日期</th>         <th>状态</th></tr>     </thead>     <tbody>       <tr>         <td>产品1</td>         <td>23/11/2013</td>         <td>待发货</td></tr>       <tr>         <td>产品2</td>         <td>10/11/2013</td>         <td>发货中</td></tr>       <tr>         <td>产品3</td>         <td>20/10/2013</td>         <td>待确认</td></tr>       <tr>         <td>产品4</td>         <td>20/10/2013</td>         <td>已退货</td></tr>     </tbody>   </table> </div>

### 表单布局

Bootstrap 提供了下列类型的表单布局：

- 垂直表单（默认）
- 内联表单
- 水平表单