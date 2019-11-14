**linux刚安装完毕 配置网关**

# 起因

VM 安装完 CentOS7 mini 后，ping 115.239.211.112（百度），可是提示connect： Network is unreachable，而且ip addr 命令也看不到具体本机的ip地址。

# 原因

CentOS7 mini 默认没有打开网卡，看到anaconda-ks.cfg文件里的配置。

# 解决

1. 命令 cd /etc/sysconfig/network-scripts/

1. 命令 ls 查看该目录文件

![img](https:////upload-images.jianshu.io/upload_images/3037211-72b2e0b54967adfc.png?imageMogr2/auto-orient/strip|imageView2/2/w/799/format/webp)

查看文件

1. 打开你的第一个文件，命令 vi ifcfg-ens33

![img](https:////upload-images.jianshu.io/upload_images/3037211-e5a7143e17cc8b8a.png?imageMogr2/auto-orient/strip|imageView2/2/w/436/format/webp)

vi打开文件

1. 修改ONBOOT为yes

- 命令 i，进入编辑模式
- esc，退出编辑模式
- 命令 :wq，保存退出文件

![img](https:////upload-images.jianshu.io/upload_images/3037211-b2776e138472d2b9.png?imageMogr2/auto-orient/strip|imageView2/2/w/453/format/webp)

修改yes

1. 最后重启网络，命令 service network restart

![img](https:////upload-images.jianshu.io/upload_images/3037211-0797b3875d8837fd.png?imageMogr2/auto-orient/strip|imageView2/2/w/558/format/webp)

重启网络