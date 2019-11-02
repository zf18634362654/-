# Cannot change version of project facet Dynamic Web Module to 2.5

在eclipse的工程上选择属性，再选择Project Facets里面中选择Dynamic Web Module ，将2.3修改为2.5，提示如下信息：

Cannot change version of project facet Dynamic Web Module to 2.5

解决方法：

在工程目录下有一个.settings文件夹，打开org.eclipse.wst.common.project.facet.core.xml，做如下修改：

installed facet="jst.web" version="2.5"

