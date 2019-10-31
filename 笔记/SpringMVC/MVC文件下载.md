SpringMVC

​    <img src="C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191025093340868.png" alt="image-20191025093340868" style="zoom: 80%;" />

文件下载有两种格式  因此需要改变Context-Disposition中的内容

```java
public void downLoad(String filename,HttpServletRequest req,HttpServletResponse res) throws IOException{
		// 改变头部信息   下列方法等效  res.setContentType()
		
		res.setHeader("Content-Disposition", "attachment;filename=lol.rar");
		//获取输出流
		ServletOutputStream os = res.getOutputStream();
		//得到文件的绝对路径  req.getServletContext().getRealPath("/")相当于 webapp         目录路径
		String path=req.getServletContext().getRealPath("files");
		System.out.println(req.getServletContext().getRealPath("/"));
		//E:\apache-tomcat-9.0.17\wtpwebapps\Ex\
		File file=new File(path,filename);//得到要下载的文件
		//把文件转换为二进制字节流  org.apache.commons.io.FileUtils
		byte[] bs = FileUtils.readFileToByteArray(file);
		//将内容写进自己的电脑
		os.write(bs);
		os.flush();
		os.close();
		
		
		
			
	}
```

