Git 中心仓库在本地  最后提交时推送给对方    分布式控制软件	·  

![image-20191027194405381](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191027194405381.png)

**Git提交项目过程**

![image-20191027224455288](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191027224455288.png)





**（ 需要建立两次链接）第一次本地和远程的ssh连接 （目的是为了免密钥登陆）  **

**第二次将本地项目和所关联仓库进行连接**

![image-20191027225013763](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191027225013763.png)

常用命令

![image-20191027194855065](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191027194855065.png)

**如何让一个项目变成Git项目**    

SSH配好后**测试连通性指令**

![image-20191027220831059](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191027220831059.png)





将本地项目和远程项目关联** 

![image-20191027221355956](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20191027221355956.png)

  **<u>Origin</u>**



**第一次发布项目 （本地-远程）**
git add .      //文件-暂存区
git commit -m "注释内容"  //暂存区-本地分支（默认master）
git push -u origin master

**第一次下载项目（远程-本地）**
git clone git@github.com:yanqun/mygitremote.git

**提交(本地-远程)**
(在当前工作目录 右键-git bash)
git add.
git commit -m "提交到分支"
git push  origin master

**更新(远程-本地)**
git pull （远程-本地）





**在Eclipse中使用Git**

Egit：在Eclipse中操作git
目前的eclipse基本都支持git，如果不支持 则到eclplise marktplace 搜git安装
配置：
a.team-git-configuration -邮箱 用户名
b.general -network -ssh2选中 生成的ssh目录

**第一次发布**
share project
加入暂存区add to index
提交到本地分支commit 
将项目推送到远程	  右键-team -remote -push ---

**提交**
team-add to index
team -commit
team -push

**commit时**：
commit and push 或commit按钮的区别：
commit按钮：不能单独的Push某一个文件，只能Push整个项目
commit and push：可以 单独Push某一个文件

**第一次下载**
import -clone -输入 https/ssh的唯一标示符

**更新**
team - remote -pull