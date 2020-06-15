# Linux补充





## 桥接，NAT，主机模式三种上网

![image-20200423200548223](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200423200548223.png)

1）桥接:会给虚拟机的linux分配一个真实的Ip  ，会占用该网段的IP地址，而且其他主机可以访问到该虚拟机

2）NAT:会给虚拟机的linux主机和母鸡分配一个非本网段的IP，如果虚拟机和母机上网，可以通过真实的Ip地址上网，不会造成IP冲突

3）主机模式：虚拟机是一台独立的电脑，不能访问外网

NAT详解

![image-20200426214119913](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200426214119913.png)

介绍:**Windows有两块网卡，一块虚拟网卡，一块物理网卡**![image-20200426214155290](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200426214155290.png)

**而虚拟机和虚拟网卡组成局域网，通过真实网卡代理与外网进行交流**

![image-20200426214308190](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200426214308190.png)

**虚拟网卡ip地址修改**



![image-20200426214550925](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200426214550925.png)



**网关**

**![image-20200426214646039](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200426214646039.png)**

## 切换用户

su  root     



**权限高的用户切换到权限低的用户需要密码  反之不需要**



## > 和 >>覆盖

一个箭头表示>  覆盖 指令

两个>>    表示追加 指令

如![image-20200423215824539](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200423215824539.png)

查看a.txt的内容

![image-20200423215851040](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200423215851040.png)





## grep和|

![image-20200423221402219](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200423221402219.png)

grep过滤查找，管道符，| 表示将前一个命令的处理结果传递给后边的命令处理

**详解**

> 一般来说，百 如果要在一个具体存在的文件中查找， 那么用 grep, 比如度
>grep "main" test.c
>用来搜索知 test.c里是否包含字串 main
>
>如果要在搜道索一个命令的输出中是否包含某个回字符串，那么用 | grep, 比如
>ls | grep "main"
>用来搜索 ls 命令执行后答的输出中，是否包含 main 



## 压缩和解压文件

**gzip     压缩文件**

用法

```kotlin
gzip  hello.txt
```

说明：会把原来的文件给覆盖掉之结成为.zip



**unzip  解压文件**

```
unzip hello.txt.zip
```





**tar  既可以解压也可以压缩**

结果为.tar.gz结尾的文件

根据指令选项进行压缩还是解压

```
tar -zcvf a.tar.gz   a.txt b.txt    --将a和b压缩成一个a.tar.gz中
```

```
tar -zxvf a.tar.gz  ../  --将文件解压到当前文件
```



## 组管理和权限管理

三个配置文件

```
用户组配置文件(用户信息)   /etc/passwd
口令配置文件（密码和登录信息，被加密）  /etc/shadow
组配置文件(组信息)   /etc/group
/home/   用户家目录  每个用户登录登陆时自动进入自己的家目录
```



**chown   改变文件所有者**（但不会改变所有组）

```
chown  tom hello.txt  -- 把文件所有者改为tom
```





其他组

除了文件的所有者和所在组的用户外，系统的其他用户都是文件的其他组





## **定时调度**

crontab  [选项] 

```
crontab -e  --然后进行编辑   
-l查询调度任务  
-r 删除当前用户所有调度任务
```

```
*/1 * * * * ls -l /etc >> /tmp/he.txt
```

脚本意思 ：每分钟 将ls -l的内容追加到/tmp/he.txt中



案例：凌晨两点备份数据库将mysql数据库testdb 备份到文件中mydb.bak

```
1)先编写一个文件 /home/mytask.sh
   /user/local/mysql/bin/mysqldump -u root -proot testdb > /tmp/myda.bak
2)给mytask.sh一个可执行权限
   chmod 744 /home/mytask.sh
3)crontab -e 
4)0 2 * * * /home/mytask.sh
5)结束
```

## 进程管理

p

```
ps -a 显示当前终端的所有进程信息
ps -u 以用户的格式显示进程信息
ps -x 显示后台进程运行的参数
```

![image-20200426225622811](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200426225622811.png)

**终止进程**

kill

kill -9 120   --表示强制杀死进程号为120的进程杀掉





## 通过 telnet进行端口测试

```
telnet 192.168.2.127 22  --测试端口是否打开
```

## 服务运行级别

![image-20200426231554030](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20200426231554030.png)

### **RPM  软件安装包（红帽旗下）本地安装**  

```
 rpm -qa|grep java  --查看本机是否安装java
 rpm -qa firefox  --查看软件安装在哪个目录
```

### **YUM  在线下载（管理RPM）**

