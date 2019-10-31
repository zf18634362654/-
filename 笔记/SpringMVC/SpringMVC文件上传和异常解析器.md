SpringMVC文件上传类型![image-20191025094819377](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191025094819377.png)

配置文件上传的解析器Springmvc配置文件中  可以设置文件大小 文件编码

![image-20191025095247056](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191025095247056.png)

```java
	public String upLoad(String desc,MultipartFile file) throws IOException
	{    //得到的文件名可能带路径 如IE浏览器
		System.out.println(desc);
		String filename=file.getOriginalFilename();
		//防止文件命重复
		String suffix=filename.substring(filename.lastIndexOf("."));
		String uuid=UUID.randomUUID().toString();
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:/"+uuid+suffix));
		 return "123";
	}
	
```

 get方式上传字符流

post方式上传字节流

异常处理解析器

![image-20191025101809935](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191025101809935.png)

key中为异常命  若有多个异常捕获 则在props标签下多配几个