# AJAX与后台传送数据总结:(Jquery实现)



## 第一种   URL拼接（&）





```javascript
$.ajax({  
    //请求方式   
    type:'POST',  
//发送请求的地址 
    url:'delete',   
    
    //服务器返回的数据类型   
    dataType:'json',
    
    //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式   
    data:{id:value},
    
    //如不设置此项，默认也为此，设置发送给后端的类型
    contentType:"application/x-www-form-urlencoded",
    
    success:function(data){        //请求成功函数内容        alert("请求成功");    },    
        error:function(jqXHR){        //请求失败函数内容    }});
```







## 第二种 JSON传输  一般用于对象映射

```javascript
$.ajax({    //请求方式   
type:'POST',   
//发送请求的地址   
url:'insert',   
    
//服务器返回的数据类型    
dataType:'json',
    
//发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式  
    
 data:JSON.stringify({"volunteerSno":128,"volunteerSex":"nan"}),    contentType:"application/json; charset=utf-8",     
 success:function(data){        
     //请求成功函数内容       
     alert("请求成功");    },
     
     error:function(jqXHR)
{        //请求失败函数内容    
}});
```





## **Get请求在URl后拼串     Get请求会产生缓存**



**$.ajax({**
**//请求方式**
    **type:'GET',**
    **//发送请求的地址以及传输的数据**
    **url:'fzz.php?number'+=xxx,**
    **//服务器返回的数据类型**
    **dataType:'json',**
    **success:function(data){**
        **//请求成功函数内容**
    **},**
    **error:function(jqXHR){**
        **//请求失败函数内容**
    **}**
**});**



## serialize()方法

1.serialize() 方法通过序列化表单值，创建 URL 编码文本字符串。 
2.serialize()作用于一个jQuery对象，能够将DOM元素内容序列化为字符串,用于Ajax请求

案例

```html
<html>
<head>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $("button").click(function(){
    $("div").text($("form").serialize());
  });
});
</script>
</head>
<body>
<form action="">
First name: <input type="text" name="FirstName" value="Bill" /><br />
Last name: <input type="text" name="LastName" value="Gates" /><br />
</form>

<button>序列化表单值</button>
<div></div>
</body>
</html>

点击后得到:  FirstName=Bill&LastName=Gates
————————————————

```

