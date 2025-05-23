# Java的IO模型、Netty原理详解

# 1.什么是IO

虽然作为Java开发程序员，很多都听过IO、NIO这些，但是很多人都没深入去了解这些内容。

* Java的I/O是以流的方式进行数据输入输出的，Java的类库涉及很多领域的IO内容：标准的输入输出，文件的操作、网络上的数据传输流、字符串流、对象流等

# 2.同步与异步、阻塞与非阻塞

* 同步：一个任务完成之前不能做其他操作，必须等待。
* 异步：一个任务完成之前，可以进行其他操作
* 阻塞：相对于CPU来说，挂起当前线程，不能做其他操作只能等待
* 非阻塞：CPU无需挂起当前线程，可以执行其他操作

# 3.三种IO模型

## BIO（Blocking I/O）

**同步并阻塞模式**，调用方在发起IO操作时会被阻塞，直到操作完成才能继续执行，适用于连接数较少的场景。

例如：服务端通过ServerSocket监听端口，accept()阻塞等待客户端连接。

优缺点：

* 优点：实现简单
* 缺点：线程资源开销大，连接数多时，每个线程都要占用CPU资源，容易出现性能瓶颈

适用于低并发、短连接的场景，如传统的HTTP服务

![](D:\IdeaProjects\find-next-dragon\bagu\重点\图片\1.png)

## NIO（Non-blocking I/O）

**同步非阻塞模型**，客户端发送的连接请求都会注册到**Selector多路复用器**上，服务器端通过Selector管理多个通道Channel，Selector会轮询这些连接，当轮询到连接上有IO活动就进行处理。

NIO基于 Channel 和 Buffer 进行操作，数据总是从通道读取到缓冲区或者从缓冲区写入到通道。Selector 用于监听多个通道上的事件（比如收到连接请求、数据达到等等），因此使用单个线程就可以监听多个客户端通道。

**IO多路复用**：一个线程可对应多个连接，不用为每个连接都创建一个线程

![](D:\IdeaProjects\find-next-dragon\bagu\重点\图片\2.png)

核心组件：

* Channel：双向通信通道（如SocketChannel），数据可流入流出
* Buffer：数据缓冲区，是双向的，可读可写
* Selector：一个Selector对应一个线程，一个Selector上可注册多个Channel，并轮询多个Channel的就绪事件

优缺点：

* 可以减少线程数量，降低线程切换的开销，适用于需要处理大量并发连接的场景
* 缺点：实现复杂度高

使用于高并发、长连接的场景，如即时通讯场景

## AIO（Asynchronous I/O）

**异步非阻塞模型**，基于事件回调或Future机制

* 调用方发起IO请求后，无需等待操作完成，可继续执行其他任务。操作系统在IO操作完成后，通过回调或事件通知的方式告知调用方
* Java中`AsynchronousSocketChannel`是AIO的代表类，通过回调函数处理读写操作完成后的结果

优缺点：

* IO密集型的应用，AIO提供更高的并发和低延迟，因为调用方在等待IO时不会被阻塞
* 缺点：实现复杂

适用于高吞吐、低延迟的场景，如日志批量写入



# 4.什么是Netty

说起Java的IO模型，绕不开的就是Netty框架了，那什么是Netty，为什么Netty的性能这么高呢？

* Netty是由JBOSS提供的一个Java开源框架。提供异步的、事件驱动的网络应用程序框架和工具，用以快速开发高性能、高可靠性的网络服务器
* Netty的原理就是NIO，是基于NIO的完美封装

很多中间件的底层通信框架用的都是它，比如：RocketMQ、Dubbo、Elasticsearch

## 4.1 Netty的核心要点

核心特点：

* 高并发：通过**多路复用Selector**实现单线程管理大量连接，减少线程开销
* 传输快：**零拷贝技术**，减少内存拷贝次数
* 封装性：简化NIO的复杂API，提供链式处理（ChannelPipeline）和可扩展的编解码能力（如Protobuf支持）

高性能的核心原因：

* **主从Reactor线程模型**，无锁化设计，减少线程竞争
* **零拷贝技术**，堆外内存直接操作
* 高效内存管理，对象池技术，**预分配内存块并复用**，对象复用机制
* **基于Selector的I/O多路复用**，异步事件驱动机制
* **Selector空轮询问题修复**

## 4.2 零拷贝技术

Netty的零拷贝体现在操作数据时, 不需要将数据 buffer从 一个内存区域拷贝到另一个内存区域。少了一次内存的拷贝，CPU 效率就得到的提升。

### **4.2.1 Linux系统的文件从本地磁盘发送到网络中的零拷贝技术**

![](D:\IdeaProjects\find-next-dragon\bagu\重点\图片\3.png)

* 内核缓冲区是 Linux 系统的 Page Cahe。为了加快磁盘的 IO，Linux 系统会把磁盘上的数据以 Page 为单位缓存在操作系统的内存里
* 内核缓冲区到 Socket 缓冲区之间并没有做数据的拷贝，只是一个地址的映射，底层的网卡驱动程序要读取数据并发送到网络上的时候，看似读取的是 Socket 的缓冲区中的数据，其实直接读的是内核缓冲区中的数据。
* 零拷贝中所谓的“零”指的是**内存中数据拷贝的次数为 0**

### **4.2.2 Netty零拷贝技术**

* 使用了堆外内存进行Socket读写，避免JVM堆内存到堆外内存的数据拷贝
* 提供了CompositeByteBuf合并对象，可以组合多个Buffer对象合并成**一个逻辑上的对象**，用户可以像操作一个Buffer那样对组合Buffer进行操作，避免传统内存拷贝合并
* 文件传输使用FileRegion，封装FileChannel#transferTo()方法，**将文件缓冲区的内容直接传输到目标Channel**，避免内核缓冲区和用户态缓冲区间的数据拷贝

### **4.2.3 Netty和操作系统的零拷贝的区别？**

Netty 的 Zero-copy 完全是在用户态（Java 应用层）的, 更多的偏向于优化数据操作。而在 OS 层面上的 Zero-copy 通常指避免在用户态（User-space）与内核态（Kernel-space）之间来回拷贝数据

## 4.3 Reactor模式

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/图片/4.png)

* 基于IO多路复用技术，多个连接共用一个多路复用器，程序只需要阻塞等待多路复用器即可
* 基于线程池技术复用线程资源，程序将连接上的任务分配给线程池中线程处理，不用为每个连接单独创建线程
* Reactor是图中的ServiceHandler，在一个单独线程中运行，负责监听和分发事件

Reactor可以分为单Reactor单线程模式、单Reactor多线程模型，主从Reactor多线程模型

### 4.3.1 单Reactor单线程模式

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/图片/5.png)

* Reactor通过select监听客户端请求事件，收到事件后通过dispatch分发

该模式简单，**所有操作都由1个IO线程处理**，缺点是存在性能瓶颈，只有1个线程工作，无法发挥多核CPU的性能。

### 4.3.2 单Reactor多线程模式

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/图片/6.png)

* Reactor主线程负责接收建立连接事件和后续的IO处理，Worker线程池处理具体业务逻辑

充分发挥了多核CPU的处理能力，缺点是用一个线程接收事件和响应，高并发时仍然会有性能瓶颈

### 4.3.3 主从Reactor多线程模式

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/图片/7.png)

* Reactor主线程负责通过select监听连接事件，通过acceptor处理连接事件
* Reactor从线程负责处理建立连接后的IO处理事件
* worker线程池负责业务逻辑处理，并将结果返回给Handler

该模式优点是主从线程分工明确，能应对更高的并发。缺点是编程复杂度较高。

应用该模式的中间件有：**Dubbo、RocketMQ、Zookeeper**等

### 小结

Reactor模式的核心在于用一个或少量线程来监听多个连接上的事件，根据事件类型分发调用相应处理逻辑，从而避免为每个连接都分配一个线程

## 4.4 Netty的线程模型

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/重点/图片/8.png)

* **BossGroup**：boss线程组，负责接收客户端的连接请求，连接来了之后，将其注册到Worker线程组的NioEventLoop中
* **WorkerGroup**：Worker线程组，每个线程都是一个NioEventLoop，负责和处理一个或多个Channel的I/O读写操作。处理逻辑通常是通过ChannelPipeline中的各个ChannelHandler来完成
* 业务线程组（可选）：还可以引入一个业务线程组来处理业务逻辑，避免阻塞Worker线程

简单理解：Boss线程是老板，Worker线程是员工，老板负责接收处理的事件请求，Worker负责工作，处理请求的I/O事件，并交给对应的Handler处理

本质是将**线程连接**和具体的**业务处理**分开

# 5.多路复用I/O的3种机制

## 5.1 select

这三种都是操作系统中的多路复用I/O机制

**轮询机制**：select使用一个固定大小的位图来表示文件描述符集，将文件描述符的状态（如可读、可写）存储在一个数组中，调用select时，每次需将完整的位图从用户空间拷贝到内核空间，内核遍历所有描述符，检查就绪状态

局限：

* 文件描述符限制通常为1024，限制了并发处理数
* 性能低：搞并发场景，每次都要遍历整个位图，性能开销大，时间负责度为O(N)

## 5.2 poll

poll使用了动态数组来替代位图，使用pollfd结构数组存储文件描述符和事件，无数量限制

工作机制：每次调用时仍然需要遍历所有描述符，即使只有少量描述符修改了，仍然要检查整个数组，时间复杂度为O(N)

## 5.3 epoll

**1）事件驱动模型**：epoll使用**红黑树**来存储和管理注册的文件描述符，使用**就绪事件链表**来存储触发的事件。当某个文件描述符上的事件就绪时，epoll会将该文件描述符添加到就绪链表中。

**2）触发模式**：支持水平触发（LT）和边缘触发（ET），ET模式下事件仅通知一次

* 水平触发（Level Triggered），默认模式，只要文件描述符上有未处理的数据，**每次调用epoll_wait都会返回该文件描述符**
* 边缘触发（Edge Triggered），**仅在状态发生变化时通知一次**，减少重复事件的通知次数

**3）工作流程**：

* `epoll_create`创建实例：分配相应数据结构，并返回一个epoll文件描述符。内核分配一棵红黑树管理文件描述符，以及一个就绪事件的链表
* `epoll_ctl`注册、修改、删除事件：epoll_ctl是用于管理文件描述符与事件关系的接口
* `epoll_wait`等待事件：epoll会检查就绪事件链表，将链表中所有就绪的文件描述符返回给用户空间。**epoll_wait高效体现在它返回的是已经发生事件的文件描述符，而不是遍历所有注册的文件描述符**

优点是时间复杂度O(1)，仅处理活跃连接，性能和连接数无关

**4）零拷贝机制**：

* 通过内存映射mmap减少了在内核和用户空间之间的数据复制，进一步提高了性能

总结：epoll每次只传递发生的事件，不需要传递所有文件描述符，所以提高了效率

# 6. Netty如何解决JDK NIO空轮询bug的？

Java NIO在Linux系统下默认是epoll机制，理论上无客户端连接时Selector.select()方法是会阻塞的。

发生空轮询bug表现时，即时select轮询事件返回数量是0，Select.select()方法也不会被阻塞，NIO就会一直处于while死循环中，不断向CPU申请资源导致CPU 100%

**底层原因**：

* Linux内核在某些情况下会错误地将Selector的EPOLLUP（连接挂起）和EPOLLERR（错误）事件标记为就绪状态，JDK中的NIO实现未正确处理这些事件，导致select()方法误判事件存在而提前返回

### 6.1 Netty的解决方式

Netty并没有解决这个bug，而是绕开了这个错误，具体如下：

1）**统计空轮询次数**：通过selectCnt计数器来统计连续空轮询的次数，每次执行Selector.select()方法后，如果发现没有IO事件，selectCnt就会递增

2）**设置阈值**：定义了一个阈值，默认为512，当空轮询达到这个阈值时，Netty就会触发重建Selector的操作

3）**重建Selector**：Netty新建一个Selector，并将所有注册的Channel从旧的Selector转移到新的Selector上，过程涉及取消旧Selector上的注册，以及新Selector上重新注册

4）关闭旧的Selector：重建Selector并将Channel重新注册后，Netty关闭旧的Selector

总结：通过SelectCnt统计没有IO事件的次数，来判断当前是否发生了空轮询，如果发生了，就重建一个Selector来替换之前出问题的Selector

核心代码如下：
```java

long time = System.nanoTime();

//调用select方法，阻塞时间为上面算出的最近一个将要超时的定时任务时间
int selectedKeys = selector.select(timeoutMillis);

//计数器加1
++selectCnt;

if (selectedKeys != 0 || oldWakenUp || this.wakenUp.get() || this.hasTasks() || this.hasScheduledTasks()) {
   //进入这个分支，表示正常场景     

   //selectedKeys != 0: selectedKeys个数不为0, 有io事件发生
   //oldWakenUp:表示进来时，已经有其他地方对selector进行了唤醒操作
   //wakenUp.get()：也表示selector被唤醒
   //hasTasks() || hasScheduledTasks()：表示有任务或定时任务要执行
   //发生以上几种情况任一种则直接返回

   break;
}

//此处的逻辑就是： 当前时间 - 循环开始时间 >= 定时select的时间timeoutMillis，说明已经执行过一次阻塞select(), 有效的select
if (time - TimeUnit.MILLISECONDS.toNanos(timeoutMillis) >= currentTimeNanos) {
   //进入这个分支，表示超时，属于正常的场景
   //说明发生过一次阻塞式轮询, 并且超时
   selectCnt = 1;
} else if (SELECTOR_AUTO_REBUILD_THRESHOLD > 0 && selectCnt >= SELECTOR_AUTO_REBUILD_THRESHOLD) {
   //进入这个分支，表示没有超时，同时 selectedKeys==0
   //属于异常场景
   //表示启用了select bug修复机制，
   //即配置的io.netty.selectorAutoRebuildThreshold
   //参数大于3，且上面select方法提前返回次数已经大于
   //配置的阈值，则会触发selector重建

   //进行selector重建
   //重建完之后，尝试调用非阻塞版本select一次，并直接返回
   selector = this.selectRebuildSelector(selectCnt);
   selectCnt = 1;
   break;
}
currentTimeNanos = time;
```

