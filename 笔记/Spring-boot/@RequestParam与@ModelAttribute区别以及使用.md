**@RequestParam与@ModelAttribute区别以及使用**

1、@RequestParam，@RequestParam("xx") 表示在前端传递过来的参数中必须有个参数名称为“xx”（可以使用required=false避免必须）

2、@ModelAttribute，@ModelAttribute("xx") 表示将前端传递过来的参数按照名称注入到对应的对象中，“xx”只是表示放到ModelMap中的key值





@ModelAttribute有三种用法： 

- 可以标注在方法上； 
- 可以标注在方法中的参数上； 
- 还可以和@RequestMapping一起标注在方法上； 
三种方式各不一样，下面分别演示

一、@ModelAttribute标注在方法上
@ModelAttribute标注的方法会在Controller类的每个映射url的控制执行方法之前执行。 
1、@ModelAttribute标注的方法返回空值 
创建控制视图类：

@Controller
public class MyModelAttribute {

    /*Model为模型，表示把数据放在返回的视图页面上*/
    @ModelAttribute
    public void testModeelAttribute(Model model){
        model.addAttribute("username", "lzj");
    }
    
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
在src/main/resources/templates目录下创建视图模板hello.ftl：

<h1>This is Hello Page</h1>
<p>username: ${username}</p>
1
2
运行工程，在浏览器中输入http://localhost:8080/hello后，控制视图方法hello()响应该请求，但在执行hello()方法之前先要执行@ModelAttribute标注的testModeelAttribute()方法。



2、@ModelAttribute标注的方法响应带输入参数的请求

@Controller
public class MyModelAttribute {

    @ModelAttribute
    public void testModeelAttribute(@RequestParam("name") String name1, Model model){
        model.addAttribute("username", name1);
    }
    
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}

比如浏览器中输入http://localhost:8080/hello?name=lzj后，由控制视图类中的hello()方法来执行请求，在执行请求之前先执行testModeelAttribute()方法。由于请求中传入了name参数，testModeelAttribute()中先通过@RequestParam("name") String name1 把请求参数的name值放在程序中的name1变量中。也可以像下面这样写

public void testModeelAttribute(String name, Model model)
1
这样就不需要@RequestParam注解，但是String name的定义的name变量名就要与请求中name名保持一致。

3、@ModelAttribute标注的方法返回对象 
控制视图类：

@Controller
public class MyModelAttribute {

    @ModelAttribute
    /*1.把请求链接中的name属性的值赋给username变量，请求链接中的age属性赋给age变量；
    2.返回类型为对象，相当于把返回的对象放到了请求模型中，返回的对象相当于模型中的值，键相当于@ModelAttribute注解标注的方法的首字母小写，即testModeelAttribute；
    即model.addAttribute("testModeelAttribute", user);
    */
    public User testModeelAttribute(@RequestParam("name") String username, @RequestParam("age") Integer age){
        User user = new User();
        user.setUsername(username);
        user.setAge(age);
        return user;
    }
    
    @RequestMapping("/user")
    /*模型中已经放入属性和值，model.addAttribute("testModeelAttribute", user)；然后通过@ModelAttribute("testModeelAttribute")标注在属性上，表示把模型中的testModeelAttribute键对应的value值赋给了usr。*/
    public String User(@ModelAttribute("testModeelAttribute") User usr, Model model){
        model.addAttribute("user", usr);
        return "user";
    }
}
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
User类为：

public class User {

    private String username;
    private int age;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User [username=" + username + ", age=" + age + "]";
    }

}
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
user.ftl视图模板为：

<h1>This is User Page</h1>
<p>user: ${user}</p>
1
2
启动spring boot工程，在浏览器中输入http://localhost:8080/user?name=lzj&age=20，控制视图方法响应请求前，先执行@ModelAttribute注解标注的testModeelAttribute方法，该方法把testModeelAttribute键对应的值user放到视图中，在user()响应方法中获取模型中testModeelAttribute对应的值，然后又放到了视图中。 

4、@ModelAttribute标注方法时，指定放在模型中的键值 
在上面一个例子中，@ModelAttribute标注的testModeelAttribute（）方法默认把键为testModeelAttribute，value值为user的键值对放在了model模型中。但是我们可以显示指定放在模型中的键的名字。

    /*相当于把model.addAttribute("userAttribute", user)放在了请求模型中*/
    @ModelAttribute("userAttribute")
    public User testModeelAttribute(@RequestParam("name") String username, @RequestParam("age") Integer age){
        User user = new User();
        user.setUsername(username);
        user.setAge(age);
        return user;
    }
    
    @RequestMapping("/user")
    /*把请求模型中userAttribute键对应的值赋给usr变量中*/
    public String User(@ModelAttribute("userAttribute") User usr, Model model){
        usr.setAge(25);
        model.addAttribute("user", usr);
        return "user";
    }
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
二、@ModelAttribute标注在方法的参数上
当@ModelAttribute属性标识在方法的参数上时，表示从请求域的模型中读取属性。例如

@Controller
public class MyModelAttribute {

    @ModelAttribute("name")
    public void regNameModeelAttribute(Model model){
        model.addAttribute("name", "lzj");
    }
    
    @ModelAttribute
    public void regAgeModeelAttribute(Model model){
        /*把键值属性放到请求模型中*/
        model.addAttribute("age", "20");
    }
    
    @RequestMapping("/reg")
    /*@ModelAttribute标识在参数的前面，表示从请求模型的中读取键值为name的属性的value值放在username中*/
    public String reg(@ModelAttribute("name") String username, @ModelAttribute("age") String age){
        System.out.println("name:" + username + "; age:" + Integer.valueOf(age));
        return "reg";
    }
}
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
启动工程，在浏览器中输入http://localhost:8080/reg后，控制视图方法reg()响应请求前，先执行regNameModeelAttribute()和regAgeModeelAttribute()方法，最后后台输出：name:lzj; age:20

三、@ModelAttribute和@RequestMapping同时标注在同一个方法上
当两个注解同时标注在一个方法上时，该方法返回的内容不再被视图解析器解析为视图了，而是把放回的内容放到模型的属性中，视图还是继续返回@RequestMapping映射的那个视图。

@Controller
public class MyModelAttribute {

    @RequestMapping("/login")
    @ModelAttribute("name")
    public String login(@RequestParam(value="username", required=false) String username){
        System.out.println("--username-- : " + username);
        return username;
    }
}
1
2
3
4
5
6
7
8
9
10
当login()方法响应请求后，执行方法，然后把方法的返回值username放到请求模型的name属性中，相当于model.addAttribute("name", username) 。当请求方法执行完后，会把请求的url继续返回到浏览器。 
login.ftl模板视图：

<h1>This is Login Page</h1>
<p>name: ${name}</p>
1
2
启动工程，在浏览器中输入http://localhost:8080/login?username=lzj后，login()方法响应后，显示login.ftl网页。 

文章参考了http://write.blog.csdn.net/mdeditor
————————————————
版权声明：本文为CSDN博主「苍鹰蛟龙」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/u010502101/article/details/78876295