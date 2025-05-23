# CompletableFuture原理及应用场景详解

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/CompletableFuture.png)

## 1.应用场景

现在我们打开各个APP上的一个页面，可能就需要涉及后端几十个服务的API调用，比如某宝、某个外卖APP上，下面是某个外卖APP的首页。首页上的页面展示会关联很多服务的API调用，如果使用同步调用的方式，接口耗时完全不能满足需求，因此，需要用到异步调用的方式。

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/CF0_1.jpg)

## 2.使用线程池的弊端

说起异步调用，我们通常是创建一个线程池来实现多个请求的并行调用，这样接口的整体耗时由执行时间最长的线程决定。

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/CF0_2.png)

但是线程池存在的问题是资源利用率较低：

* CPU资源大量浪费在阻塞等待上
* CPU调度的线程数增加了，在上下文切换上的资源消耗更大了。而且线程本身也占用系统资源

## 3.CompletableFuture的特性

我们引入CompletableFuture对业务流程进行编排，降低依赖之间的阻塞。本文主要讲述CompletableFuture的使用和原理。并对比Future、CompletableFuture、RxJava、Reactor的特性

|                             | Future | CompletableFuture | RxJava | Reactor |
| :-------------------------- | :----- | :---------------- | :----- | ------- |
| Composable（可组合）        | ❌      | ✔️                 | ✔️      | ✔️       |
| Asynchronous（异步）        | ✔️      | ✔️                 | ✔️      | ✔️       |
| Operator fusion（操作融合） | ❌      | ❌                 | ✔️      | ✔️       |
| Lazy（延迟执行）            | ❌      | ❌                 | ✔️      | ✔️       |
| Backpressure（回压）        | ❌      | ❌                 | ✔️      | ✔️       |

* **可组合**：将多个依赖操作通过不同方式进行编排，例如CompletableFuture提供thenCompose、thenCombine等方法，这些方法支持了可组合的特性
* **操作融合**：将数据流中的多个操作符以某种方式结合起来，进而降低开销
* **延迟执行**：操作不会立即执行，当收到明确指示时才会触发操作
* **回压**：异步阶段的处理速度跟不上，直接失败会导致大量数据丢失，这是需要反馈上游生产者降低调用量

RxJava和Reactor虽然功能更强大，但是学习成本也更高，我们选择学习成本较低的CompletableFuture



## 4 一个例子回顾Future

CompletableFuture是由Java 8引入的，在Java8之前我们一般通过Future实现异步，而Future是Java5新加的接口，提供异步并行计算的功能

* Future只能通过阻塞或者轮询的方式获取结果，且不支持设置回调方法
* Future.get()方法是阻塞调用获取结果，还提供了isDone方法，在程序中轮询这个方法可查询执行结果

创建任务方法类

```java
public class UserService {

    public String getUserInfo() throws InterruptedException {
        Thread.sleep(300L);
        return "getUserInfo() 返回结果";
    }

    public String getUserAddress() throws InterruptedException {
        Thread.sleep(500L);
        return "getUserAddress() 返回结果";
    }
}
```

创建Future测试

```java
public class FutureTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        UserService userService = new UserService();
        try {
            Long start = System.currentTimeMillis();
            Future<String> future1 = executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return userService.getUserInfo();
                }
            });
            Future<String> future2 = executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return userService.getUserAddress();
                }
            });
            String result1 = future1.get();
            System.out.println(result1);
            String result2 = future2.get();
            System.out.println(result2);

            System.out.println("两个任务执行耗时：" + (System.currentTimeMillis() - start) + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
```

最后执行结果为：

```shell
getUserInfo() 返回结果
getUserAddress() 返回结果
两个任务执行耗时：505 ms
```

使用Future后任务的整体耗时，由最长的任务耗时决定

前面也说过，Future对结果的获取不友好，没有提供回调方法，只能阻塞或者轮询的方式。

Java8之前也可以用guava的ListenableFuture，来设置回调，但是这样又会导致臭名昭著的回调地狱（异步编程中因多层嵌套回调函数导致的代码可读性、可维护性急剧下降的现象），这里不展开了

## 5.CompletableFuture的使用

CompletableFuture实现了两个接口：Future和CompletionStage，Future用于异步计算，CompletionStage用于表示异步执行过程汇总的一个步骤Stage

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/CF1.png)

### 5.1一个例子入门CompletableFuture

这里创建一个流程，多个任务之间存在依赖关系

根据依赖数量，可以分为：零依赖、一元依赖、二元依赖、多元依赖

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/CF2.png)

### 5.1.1零依赖：创建异步任务

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/CF3.png)

上面两个任务CF1、CF2就是零依赖，可以直接创建，主要有三种创建方式：

```java
        ExecutorService executor = Executors.newFixedThreadPool(5);
        UserService userService = new UserService();
        //1、使用runAsync或supplyAsync发起异步调用
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() ->
                userService.getUserInfo(), executor);
        //2、CompletableFuture.completedFuture()直接创建一个已完成状态的CompletableFuture
        CompletableFuture<String> cf2 = CompletableFuture.completedFuture("result2");
        //3、先初始化一个未完成的CompletableFuture，然后通过complete() completeExceptionally()，完成该CompletableFuture
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.complete("success");
```

### 5.1.2 一元依赖：依赖一个CF

任务的执行存在一个上游依赖，可以通过**thenApply**、thenAccept、thenCompose方法来实现

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/CF4.png)

```java
CompletableFuture<String> cf3 = cf1.thenApply(result1 -> {
  //result1为CF1的结果
  //......
  return "result3";
});
CompletableFuture<String> cf5 = cf2.thenApply(result2 -> {
  //result2为CF2的结果
  //......
  return "result5";
});
```

### 5.1.3 二元依赖：依赖两个CF

上图中的CF4就是个二元依赖，它依赖CF1和CF2，我们通过thenCombine等回调来实现。代码如下：

```java
CompletableFuture<String> cf4 = cf1.thenCombine(cf2, (result1, result2) -> {
            //result1和result2分别为cf1和cf2的结果
            return "result4";
        });
```

### 5.1.4 多元依赖：依赖多个CF

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/CF5.png)

CF6是多元依赖，这种关系可以通过`allOf`、`anyOf`方法来实现：

* `allOf`方法：多个依赖需全部完成
* `anyOf`方法：任意一个依赖完成即可

```java
        //多元依赖
CompletableFuture<Void> cf6 = CompletableFuture.allOf(cf3, cf4, cf5);
CompletableFuture<String> result = cf6.thenApply(v -> {
            //这里的join并不会阻塞，因为传给thenApply的函数是在CF3、CF4、CF5全部完成时，才会执行 。
            String result3 = cf3.join();
            String result4 = cf4.join();
            String result5 = cf5.join();
            //根据result3、result4、result5组装最终result;
            return result3 + result4 + result5;
        });
```



## 6.CompletableFuture原理

CompletableFuture包含了两个volatile修饰的变量：result和stack

* result存储当前CF的结果
* stack表示当前CF完成后需要触发的依赖动作，依赖动作可以有多个，以栈形成存储，stack表示栈顶元素

```java
    volatile Object result;       // Either the result or boxed AltResult
    volatile Completion stack;    // Top of Treiber stack of dependent actions
```

Completion类本身是**观察者**的基类

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/CF6.png)

**被观察者**：每个CF都是一个被观察者，stack中存储的是注册的所有观察者，当CF执行完成后，会弹栈stack，依次通知观察者。result用于存储CF执行的结果数据

**观察者**：回调方法如thenApply、thenAccept会生成一个Completion类型的对象，就是观察者。检查当前CF是否已完成，如果已完成则执行Completion，否则加入观察者链stack中



## 7.使用问题

### 7.1代码执行在哪个线程上？

CompletableFuture的组合操作都有同步和异步两种方法：

**同步方法**（即不带Async后缀的）：

* 如果注册时被依赖的操作已经执行完成，则直接由**当前线程执行**
* 如果注册时被依赖操作未执行完，则由**回调线程执行**

**异步方法**（带Async后缀的）：

* 不传递线程池参数Executor时，由公共线程池CommonPool（CPU核数-1）执行
* 传递时用的传入的指定线程池

### 7.2异步回调要传线程池

异步回调时**强制传入线程池，并根据实际情况做线程池隔离**

不传递时，使用的都是公共线程池CommonPool，容易形成性能瓶颈。手动传递线程池参数可以更方便调节参数，并给不同业务分配不同线程池，做到资源隔离

### 7.3 Future需要获取返回值，才能获取异常信息

```java
CompletableFuture<Void> future = CompletableFuture.supplyAsync(
     ......
)

  //如果不加get()方法这一行，看不到异常信息
  future.get();
```

Future需要获取返回值时，才能获取到异常信息，不加get()方法是看不到的。

CompletableFuture还提供了异常捕获回调exceptionally方法，相当于同步调用中的try/catch方法可获取异常

```java
public CompletableFuture<Integer> getCancelTypeAsync(long orderId) {
    CompletableFuture<WmOrderOpRemarkResult> remarkResultFuture = wmOrderAdditionInfoThriftService.findOrderCancelledRemarkByOrderIdAsync(orderId);//业务方法，内部会发起异步rpc调用
    return remarkResultFuture
      .exceptionally(err -> {//通过exceptionally 捕获异常，打印日志并返回默认值
         log.error("WmOrderRemarkService.getCancelTypeAsync Exception orderId={}", orderId, err);
         return 0;
      });
}
```