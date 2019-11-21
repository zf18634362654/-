**Maven  Web项目**  

集成servlet  jar包时 注意是pom文件中的还是 Tomcat中的

  将Maven架构项目打成WAR包在Tomat下运行时，可能访问路径导致问题，比如RequestMapping   访问时需要根路径

需修改配置文件 server.xml

 <Context docBase="analysis-tool-web-1.0-SNAPSHOT" path="/" reloadable="true" privileged="true"/> 

path表示站点名，项目名称，

docBase表示所在的磁盘目录

debug表示显示的debug信息的多少，0最少9最多

reloadable设置true表示可以热更新，改动内容后不需要重启服务，false则需要重启服务


