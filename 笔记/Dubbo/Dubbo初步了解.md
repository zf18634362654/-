三层架构并发程度有限

Dubbo（一种SOA 面向服务架构）将视图层与Service 和模型分离  放在各自的服务器上（客户端，服务端分离），分别在zookeeper上注册（注册的zookeeper的Ip地址相同达到绑定的目的），一个消费服务，一个提供服务。

Controller中的 xxxService由@Reference(alibaba提供)来进行依赖注入

@Autowire适用于在同一台计算机上的容器

@Reference 远程注入

