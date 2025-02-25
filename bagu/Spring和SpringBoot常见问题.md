# Spring和SpringBoot常见问题

### 1.springboot自动装配原理

自动装配可以简单理解为：**通过注解或者一些简单的配置就能在 Spring Boot 的帮助下实现某块功能。**

**SpringBoot如何实现自动装配的？**

springboot的核心注解`SpringBootApplication`看作是 @Configuration、@EnableAutoConfiguration、@ComponentScan 注解的集合，三个注解作用：

* `@EnableAutoConfiguration`：启动SpringBoot的自动配置机制
* `@Configuration`：允许在上下文中注册额外的bean或者导入其他配置类
* `@ComponentScan`：扫描被`@Component` (`@Service`,`@Controller`)注解的 bean，注解默认会扫描启动类所在的包下所有的类 ，可以自定义不扫描某些 bean

其中`@EnableAutoConfiguration`是自动装配的核心注解
