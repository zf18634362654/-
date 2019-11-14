**SpringBoot 相关配置**

SpringBoot把配置文件解析成一个对象再交给EnableAutoConfiguration

 在启动的时候加载主配置类，开启了自动配置功能 **@EnableAutoConfiguration** （ 将类路径下 META-INF/spring.factories 里面配置的所有EnableAutoConfiguration的值（自动装配类）加入到了执行计划中。 

  配置文件的属性影响了自动装配时的条件，若满足装配条件，则将满足条件对应的Bean加入到Spring容器当中



## 有关一个YAML数据结构

```
#    1. 一个家庭有爸爸、妈妈、孩子。
#    2. 这个家庭有一个名字（family-name）叫做“happy family”
#    3. 爸爸有名字(name)和年龄（age）两个属性
#    4. 妈妈有两个别名
#    5. 孩子除了名字(name)和年龄（age）两个属性，还有一个friends的集合
#    6. 每个friend有两个属性：hobby(爱好)和性别(sex)
```

上面的数据结构用yaml该如何表示呢？

```
family:
  family-name: "happy family"
  father:
    name: zimug
    age: 18
  mother:
    alias:
      - lovely
      - ailice
  child:
    name: zimug
    age: 5
    friends:
      - hobby: football
        sex:  male
      - hobby: basketball
        sex: female
```

或者是friends的部分写成

```
 friends:
      - {hobby: football,sex:  male},
      - {hobby: basketball,sex: female}
```

### 规则1：字符串的单引号与双引号

- 双引号；不会转义字符串里面的特殊字符；特殊字符会作为本身想表示的意思，如：
  ​ name: “zhangsan \n lisi”：输出；zhangsan 换行 lisi
- 单引号；会转义特殊字符，特殊字符最终只是一个普通的字符串数据，如：
  ​ name: ‘zhangsan \n lisi’：输出；zhangsan \n lisi

### 规则2：支持松散的语法

family-name = familyName = family_name

## 二、配置文件占位符

Spring Boot配置文件支持占位符，一些用法如下

### 2.1 随机数占位符

```
${random.value}
${random.int}
${random.long}
${random.int(10)}
${random.int[1024,65536]}
```

### 3

SpringBoot的数据校验出错会报异常