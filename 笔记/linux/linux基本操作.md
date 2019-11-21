**linux基本操作**



**解压操作**：tat -zxvf   文件名（可用Table补全）

**重命名文件**

mv zoo_sample.cfg  zoo.cfg

 **复制命令**：Ctrl+Insert  组合键　或　用鼠标选中即是复制。   

   **粘贴命令**：Shift+Insert  组合键　或　单击鼠标滚轮即为粘贴。 



**Windows 对应Linux中的文件格式**

  <img src="C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191118104921223.png" alt="image-20191118104921223" style="zoom:50%;" />



**centos网络配置**
	bigdata01:	192.168.2.128		192.168.2.1（网关）
	bigdata02	192.168.2.129		192.168.2.1（网关）
	bigdata03	192.168.2.130		192.168.2.1（网关）


	a.编辑-虚拟机网络编辑器
	VMNet8 (NAT)	
	i.子网 192.168.2.0
	ii.更改设置-DHCP设置 ：
		起始192.168.2.128	bigdata01
		结束192.168.2.254  
	iii.NAT设置：网关 192.168.2.1
	
	b.配置windows访问虚拟机
		网络连接-vmNet8-TCP/IP V4 - IP192.168.2.2 ， 192.168.2.1（网关）
		
	c.centos网卡
	修改网卡配置 vi /etc/sysconfig/network-scripts/ifcfg-eth0
	
	DEVICE=eth0
	HWADDR=00:0C:29:7A:D1:F2
	TYPE=Ethernet
	UUID=b129cd07-0a05-419e-a3a1-4d73d3f37917
	ONBOOT=yes
	---修改以下配置----
	NM_CONTROLLED=yes
	BOOTPROTO=static
	IPADDR=192.168.2.128
	GATEWAY=192.168.2.1
	BROADCAST=192.168.2.255
	DNS1=114.114.114.114  --如果域名无法解析，则加入dns设置（设置的内容：推荐是 当地的DNS）
	DNS2=8.8.8.8



	vi如果使用shift+z+z无法保存， 则使用 ":wq!"


	d.通过网络名访问虚拟机 (192.168.2.128 ->bigdata01)
		centos:
			vi /etc/hosts,
			追加：
			192.168.2.128 bigdata01
		windows:
			C:\Windows\System32\drivers\etc\hosts
			追加：
			192.168.2.128 bigdata01
	
	e.配置网络服务
		service NetworkManager stop
		/etc/init.d/network restart
		chkconfig NetworkManager off
		vi /etc/resolv.conf  追加nameserver 192.168.2.1
	
		重启网卡 service network restart

4.防火墙：关闭
centos:
	service iptables stop关闭防火墙
	chkconfig iptables off禁止开机自启
	查看防火墙状态service iptables status
windows:
	网络-右键 属性-关闭防火墙



5.自动同步时间
	安装用于同步时间的 ntp插件 ：
		yum -y install ntp ntpdate
	ntpdate cn.pool.ntp.org
	将系统时间写入硬盘时间
		hwclock --systohc

6.windows真实机 通过SecureCRT 操作centos
	下载SecureCRT
	通过SecureCRT 对centos进行文件的上传下载：yum install lrzsz
		上传：切换到当前目录 cd /tmp， 直接用鼠标拖拽,Zmodem...


linux:一切都是文件，一切都是命令

7.下载安装jdk （rpm方式）
	 exe  :   rpm
	 rar  :  .tar.gz
	
	下载rpm版jdk
	安装：  切到 rpm版jdk的文件夹中， rpm -ivh  jdk名字
	rpm版本的软件，安装的默认路径：/usr中，
	例如，/usr/java/jdk1.8.0_181-amd64
	
	配置环境变量：
	vi /etc/profile中的最后追加：
	
	export JAVA_HOME=/usr/java/jdk1.8.0_181-amd64
	export CLASSPATH=$JAVA_HOME$\lib:$CLASSPATH
	export PATH=$JAVA_HOME$\bin:$PATH
	
	让环境变量立刻生效： source /etc/profile

8.集群（3台） ：完整克隆
bigdata01 -> bigdata02/bigdata03
	克隆完毕后：
		a.将从计算机 的内存适当降低
		b.修改从计算中 唯一性 的配置（ip、uuid、hostname映射）
			在克隆后的bigdata02/bigdata03中
			vi /etc/sysconfig/network-scripts/ifcfg-eth0
			修改ip地址、删除uuid/hwaddr(在重启时，自动生成)
			删除文件 rm -r  /etc/udev/rules.d/70-persistent-net.rules 输入yes

			计算机名：vi /etc/sysconfig/network
		c.映射
		  
		centos:
			vi /etc/hosts,
			追加：
			192.168.2.128 bigdata01
			192.168.2.129 bigdata02
			192.168.2.130 bigdata03
	
		windows:
			C:\Windows\System32\drivers\etc\hosts
			追加：
			192.168.2.128 bigdata01
			192.168.2.129 bigdata02
			192.168.2.130 bigdata03
9.SSH免密钥登陆
	私钥：密钥留在本机
	公钥: 密钥发给本机
	bigdata01:
	生成密钥：ssh-keygen -t rsa   (密钥存放位置：/root/.ssh ，  id_rsa:私钥     id_rsa.pub)
	发送私钥（本机）： ssh-copy-id localhost    ， 需要输入bigdata01节点(root)的密码
	发送公钥（其他计算机）：ssh-copy-id bigdata02， 需要输入bigdata02节点(root)的密码
	测试免密钥登陆：
		ssh localhost
		ssh bigdata02
		

	用上述方法，给每2台计算机 设置免密钥

10.用户
	a.用户组
		groupadd bd
		
	b.在用户组中增加用户
		useradd -g bd yq
		密码
		passwd yq  回车
	
	c.提升用户的权限:  在/etc/sudoers文中设置yq的权限
			因为/etc/sudoers文件本身是只读的，所以修改该文件前，需要 将 只读禁止。
			chmod 777 /etc/sudoers      --设置sudoers 可读可写
			编辑 vi /etc/sudoers:追加
			yq     ALL=(ALL)       ALL
			还原sudoers的权限为只读：chmod 440 /etc/sudoers
		
	d:切换用户 ： 
		切换为普通用户： su 用户名	
		切换为超级管理员root：  su
			
	d.删除用户：userdel  用户名
		如果提示 正在使用，无法删除...重启后再删


		查看进程		jps
		结束进程		kill -9 进程编号