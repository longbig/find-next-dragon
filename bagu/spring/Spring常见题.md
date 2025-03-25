# Spring常见题

## 1.Spring IOC和AOP说一下

* IoC：即**控制反转**的意思，它是一种创建和获取对象的技术思想，依赖注入(DI)是实现这种技术的一种方式。传统开发过程中，我们需要通过new关键字来创建对象。使用IoC思想开发方式的话，我们**不通过new关键字创建对象，而是通过IoC容器来帮我们实例化对象**。 通过IoC的方式，可以大大降低对象之间的耦合度
* AOP：是**面向切面编程**，能够将那些与业务无关，却为业务模块所共同调用的逻辑封装起来，以减少系统的重复代码，降低模块间的耦合度。Spring AOP 就是基于动态代理的，如果要代理的对象，实现了某个接口，那么 Spring AOP 会使用 JDK Proxy，去创建代理对象，而对于没有实现接口的对象，就无法使用 JDK Proxy 去进行代理了，这时候 Spring AOP 会使用 Cglib 生成一个被代理对象的子类来作为代理。

## 2.Spring使用了哪些设计模式

* **单例模式**：Spring的Bean都是单例，只保证在每个容器中，相同ID的Bean是单例的。
* **工厂模式**：Spring通过BeanFactory和ApplicationContext创建并管理Bean对象，可以视为工厂方法，隐藏了Bean的创建过程和具体实现
* **代理模式**：Spring AOP是基于动态代理技术，使用代理模式实现切面编程，动态代理的原理是JDK的动态代理，和cglib动态代理
* **责任链模式**：Spring的过滤器和拦截器使用了责任链模式，多个过滤器和拦截器按一定的顺序执行，每个拦截器、过滤器都可以拦截请求或响应，然后做出相应处理
* **观察者模式**：Spring的事件机制是基于观察者模式的，通过ApplicationEventPublisher发布事件，由ApplicationListener监听事件，实现对象间的松耦合
* **策略模式**：例如，InstantiationStrategy决定Bean的创建方式（反射、CGLIB）。