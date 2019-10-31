**Mybatis有关多参数传参问题**

目前 将多个参数封装到一个javabean对象（pojo）,然后使用该对象传递
	**a.**传入多个参数时，不用在mapper.xml中编写parameterType 

例如

```java
Integer addStudent(Integer stuNo, Student student);
```

​    异常提示：
​	stuNo不能使用。可以使用的是： [arg3, arg2, arg1, arg0, param3, param4, param1, param2]

   **b**.命名参数
		可以在接口中通过@Param("sNo") 指定sql中参数的名字

  **c**.综合使用

```java
Integer addStudent(@Param("sNo")Integer stuNo, @Param("stu")Student student);
```

```sql
    <insert id="addStudent"  databaseId="oracle">
       	 insert into student(stuno,stuName,stuAge,graName)
       	 values(#{sNo} , #{stu.stuName},#{stu.stuAge},#{stu.graName})
    </insert>
```

