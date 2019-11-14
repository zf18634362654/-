**SpringMVC校验出错**

1.错误消息：
public String testDateTimeFormat(Student student, BindingResult result ,Map<String,Object> map) {
需要验证的数据是 Student中的birthday, SPringMVC要求 如果校验失败  则将错误信息 自动放入 该对象之后紧挨着的	BindingResult中。
即Student student, BindingResult result之间 不能有其他参数。

2. 数据校验   
	JSR303  
	Hibernate Validator 使用Hibernate Validator步骤：
	
	a.jar（注意各个jar之间可能存在版本不兼容）
	hibernate-validator-5.0.0.CR2.jar 	classmate-0.8.0.jar 	jboss-logging-3.1.1.GA.jar
	validation-api-1.1.0.CR1.jar 	hibernate-validator-annotation-processor-5.0.0.CR2.jar
	
	
	
	b配置
		<mvc:annotation-driven ></mvc:annotation-driven>
	此时mvc:annotation-driven的作用：要实现Hibernate Validator/JSR303 校验（或者其他各种校验），必须实现SpringMVC提供的一个接口：ValidatorFactory
	
	LocalValidatorFactoryBean是ValidatorFactory的一个实现类。
	<mvc:annotation-driven ></mvc:annotation-driven>会在springmvc容器中 自动加载一个LocalValidatorFactoryBean类，因此可以直接实现数据校验。
	
	c.直接使用注解
	
	public class Student {
	
		@Past//当前时间以前
		private Date birthday ;
	}
		
	
	在校验的Controller中 ，给校验的对象前增加 @Valid
			public String testDateTimeFormat(@Valid Student student, BindingResult result ,Map<String,Object> map) {
				{...}
	
	