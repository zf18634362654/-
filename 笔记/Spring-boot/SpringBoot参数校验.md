





**、SpringBoot中参数校验**

需先在Pojo类的属性上加入，在Controller层对要验证的Pojo类前加上@Valid注解 才可生效 如果校验出错，Spring Boot默认将错误信息（Message中的信息保存在Errors中（Errors必须放在第二位（ BindingResult 实现了Errors）））  可减轻Controller 压力

查看父类子类 双击类名 CTRL+T

```java
1.   @Null  被注释的元素必须为null
2. @NotNull  被注释的元素不能为null
3. @AssertTrue  被注释的元素必须为true
4. @AssertFalse  被注释的元素必须为false
5. @Min(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
6. @Max(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
7. @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
8. @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
9. @Size(max,min)  被注释的元素的大小必须在指定的范围内。
10. @Digits(integer,fraction)  被注释的元素必须是一个数字，其值必须在可接受的范围内
11. @Past  被注释的元素必须是一个过去的日期
12. @Future  被注释的元素必须是一个将来的日期
13. @Pattern(value) 被注释的元素必须符合指定的正则表达式。
14. @Email 被注释的元素必须是电子邮件地址
15. @Length 被注释的字符串的大小必须在指定的范围内
16. @NotEmpty  被注释的字符串必须非空
    

17@Range  被注释的元素必须在合适的范围内 
```

```java
 @PostMapping("registervalidate")
  public String registervalidate(@Valid @ModelAttribute User user, Errors errors, Model model){
     if(errors.hasErrors()){
         return "register";
     }
     model.addAttribute("user",user);
      System.out.println("执行到success了");
     return "success";
  }
```

```java

@PostMapping("/createOrders")
public String createOrders(@RequestBody Order dto) {
	if(dto.getUserID==null)
		return "userID不能为空";
	if(dto.getAddressID==null)
		return "addressID不能为空";
	if(dto.getComment==null)
		return "comment不能为空";
	return "sucess";

```

以上两者为借用SpingBoot注解 和传统书写比较



**加入groups时可对不同的接口进行不同的校验**

```java
Bean中添加groups分组

在User实体类中添加groups分组@NotEmpty(groups={addUser.class})与UserController中@Validated({addUser.class})对应，说明在执行saveAddUser新增用户的情况下，才对新增的用户id进行验证。


public class User {   
    //在分组addUser时，验证id不能为空，其他情况下不做验证
    @NotEmpty(groups={addUser.class})
    private String id;
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @Size(min=6 ,max= 20 ,message = "密码最少6位，最高20位")
    private String password;
   ......
}
以上三步就可以简单地完成分组验证，但是对分组验证补充一下三点：

第一是：不分配groups分组时，默认每次都需要验证。

第二是：通过groups分组可以对同一个变量进行多个验证，如下代码
//对用户名进行两次不同情况的验证。
@NotEmpty(groups={First.class})
@Size(min=1,max=10,groups={Second.class})
public String username; 

第三是：默认的情况下，不同的分组约束验证是无序的，但是在有些情况下验证的相互约束很重要（比如前一个组验证失败，后面的将不再验证等情况），所以groups分组的验证也有前后验证顺序。使用@GroupSequence注解进行排序。
/*
 * 分组顺序接口类
 */
import javax.validation.GroupSequence;
//分组序列先Frist再Second
@GroupSequence({First.class,Second.class})
public interface Group{
}
 
@Controller  
public class UserController {  
  
    @RequestMapping("/saveAdd")  
    public String saveAddUser(@Validated({Group.class}) User user, BindingResult result) {  
        if(result.hasErrors()) {  
            return "error";  
        }  
        return "success";  
    }



```

