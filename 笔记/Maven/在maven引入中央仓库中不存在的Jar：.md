**在maven中引入一个 mvn中央仓库中不存在的Jar**：
将jar自己安装到本地mvn仓库：
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=10.2.0.5.0 -Dpackaging=jar -Dfile=d:\ojdbc7.jar  

