# 注册中心如何选型？Eureka、Zookeeper、Nacos怎么选

> 这是小卷对分布式系统架构学习的第9篇文章，第8篇时只回答了注册中心的工作原理的内容，面试官的第二个问题还没回答，今天再来讲讲各个注册中心的原理，以及区别，最后如何进行选型

上一篇文章：[如何设计一个注册中心？以Zookeeper为例](https://blog.csdn.net/qq_36624086/article/details/144975248)

还是先讲讲各个中间件的区别，zookeeper已经讲过了，这里开始讲其他中间件的工作原理

## 1. Eureka工作原理

Eureka的官方文档：[Netflix Eureka](https://github.com/Netflix/eureka/wiki) 

不过只有对1.0版本的文档，2.0之后的没有了。

**官方对Eureka的解释**：一种基于 REST（表述性状态转移）的服务，主要用于 AWS 云中定位服务，以实现中间层服务器的负载均衡和故障转移。称为 Eureka 服务器。

**Eureka解决的需求**是：在AWS中，服务器经常上线/下线，因此AWS需要动态地注册/注销负载均衡器上的服务器，而Eureka就是这样作为中间层负载均衡器出现的。

### 1.1高可用架构

Eureka在多个机房部署的架构图如下，这也是它高可用的优势

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/img/9_注册中心选型1.png)

解释说明：

* 每个区域都部署一个 Eureka 集群，且该集群仅知道其区域内的实例，每个区域内至少有一个 Eureka 服务器，以处理区域故障；
* 服务向 Eureka 注册，然后每 30 秒发送一次心跳，以续租；如果客户端没有续租，90s后就会从注册中心剔除；
* 注册信息和续租信息会复制到集群中的所有Eureka节点；
* 任意客户端可以每隔30s请求一次获取注册信息，用于定位服务提供者，并发起远程调用

### 1.2 客户端-服务端间的通信

**（1）注册Register**

Eureka 客户端将运行实例的信息注册到 Eureka 服务器，注册在第一次心跳时发生（30 秒后）

**（2）续约机制Renew**

客户端每隔30 秒发送一次心跳来续租，通知 Eureka 服务器实例，当前客户端仍然处于存活状态。如果服务器在 90 秒内没有收到续租，它将把实例移出注册表；

* 续租方式是更新服务对象的最近续约时间，即lastUpdateTimestamp;

**（3）获取注册表 Fetch Registry**

* 客户端从服务器获取注册表信息并将其缓存到本地，之后客户端使用该信息表查找其他服务；

* 此信息会定期（每 30 秒）更新，通过获取上一个提取周期和当前周期之间的增量更新；
* 增量更新时，如果客户端通过比较注册表信息不匹配，则会请求整个注册表信息全量更新

**（4）下线Cancel**

Eureka Client 在程序关闭时向 Eureka Server 发送取消请求。 发送请求后，该客户端实例信息将从 Eureka Server 的实例注册表中删除。下线请求不会自动完成，需手动调用：

```java
DiscoveryManager.getInstance().shutdownComponent()
```

### 1.3自我保护机制

默认情况下，Eureka服务端在90s没有收到某个服务实例的心跳，就会注销该实例，将实例下线。如果出现大量实例心跳检测失败，Eureka就会认为是注册中心出现问题了，启动自我保护机制，**不再剔除这些失败实例**。触发条件阈值为：

* **注册表中超过15%的实例心跳检测失败**

### 1.4 小结

* Eureka属于AP模型，即牺牲一致性，来换取高可用。在部分阶段失效时，系统仍然能正常运作。但是服务节点间的数据可能不一致
* Eureka 客户端具备良好的弹性能力，即使与所有 Eureka 服务端的连接断开，它们依然能通过本地缓存机制正常工作
* 适合跨多机房，对注册中心可用性要求高的场景

## 2. Nacos工作原理

Nacos官方文档地址：[Nacos架构 2.3版本](https://nacos.io/docs/v2.3/architecture)，注册中心设计原理文档：[Nacos注册中心](https://nacos.io/docs/ebook/ynstox/)

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/img/9_注册中心选型2.png)

上面的图比较复杂，这里贴下其他人的关于注册中心这部分的架构图

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/img/9_注册中心选型3.png)

整体流程也就是服务发现那套流程：

- 服务提供者轮询注册中心集群节点地址，把自己的协议地址注册到Nacos server
- 服务消费者需要从Nacos Server上去查询服务提供者的地址（根据服务名称）
- Nacos Server需要感知到服务提供者的上下线的变化
- 服务消费者需要动态感知到Nacos Server端服务地址的变化

Nacos采用了**Pull和Push同时运作**的方式来保证本地服务实例列表的动态感知。服务消费者通过定时任务的方式每10s Pull一次数据，Nacos Server在服务提供者出现变化时，基于UDP协议PUSH更新

### 2.1 数据模型

Zookeeper使用的是抽象的树形K-V组织结构，没有专门的数据模型。 Eureka 或者 Consul 都是做到了实例级别的数据扩展。Nacos使用的是**服务-集群-实例**的三层数据模型。

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/img/9_注册中心选型4.png)

从上图的分级数据模型可以看到：

* 服务级别：保存了健康检查开关、元数据、路由机制、保护阈值等设置
* 集群保存了健康检查模式、元数据、同步机制等数据
* 实例保存了该实例的ip、端口、权重、健康检查状态、下线状态、元数据、响应时间。

### 2.2 数据一致性协议选择（CP or AP）

Nacos 因为要支持多种服务类型的注册，并能够具有机房容灾、集群扩展等必不可少的能力，是支持AP 和 CP 两种一致性协议的，默认是AP模式

- 如果注册Nacos的client节点注册时ephemeral=true，那么Nacos集群对这个client节点的效果就是AP，采用distro协议实现；
- 而注册Nacos的client节点注册时ephemeral=false，那么Nacos集群对这个节点的效果就是CP的，采用raft协议实现。

根据client注册时的属性，AP，CP同时混合存在，只是对不同的client节点效果不同。

![](/Users/yuyunlong/IdeaProjects/find-next-dragon/bagu/img/9_注册中心选型5.png)

Distro 协议则是参考了内部 ConfigServer 和开源 Eureka ，在不借助第三方存储的情况下，实现基本大同小异。Distro 重点是做了一些逻辑的优化和性能的调优。

## 3.注册中心比较

| 对比项目        | Nacos                      | Eureka      | Consul            | Zookeeper  |
| --------------- | -------------------------- | ----------- | ----------------- | ---------- |
| 一致性协议      | 支持AP和CP模式             | AP模式      | CP模式            | CP模式     |
| 健康检查        | TCP/HTTP/MYSQL/Client Beat | Client Beat | TCP/HTTP/gRPC/Cmd | Keep Alive |
| 负载均衡策略    | 权重/metadata/Selector     | Ribbon      | Fabio             | -          |
| 幂等保护        | 有                         | 有          | 无                | 无         |
| 自动注入实例    | 支持                       | 支持        | 不支持            | 支持       |
| 访问协议        | HTTP/DNS                   | HTTP        | HTTP/DNS          | TCP        |
| 监视支持        | 支持                       | 支持        | 支持              | 支持       |
| 多数据中心      | 支持                       | 支持        | 支持              | 不支持     |
| 跨注册中心同步  | 支持                       | 支持        | 不支持            | 不支持     |
| SpringCloud集成 | 支持                       | 不支持      | 支持              | 不支持     |
| Dubbo集成       | 支持                       | 不支持      | 不支持            | 不支持     |
| k8s集成         | 支持                       | 不支持      | 不支持            | 不支持     |

### 3.1选型场景

#### Nacos

适用场景包括：

- **微服务架构**：微服务架构，尤其是需要动态服务发现和配置管理时，Nacos 是一个不错的选择。
- **云原生应用**：Nacos 提供了良好的 Kubernetes 支持，适合运行在云环境中的应用。
- **弹性功能**：如果系统需要负载均衡和服务治理功能，Nacos 提供强大的支持。

#### Eureka

- **Spring Cloud 生态系统**：如果您的项目是基于 Spring Cloud 的，Eureka 是最常用的注册中心，集成非常简单。
- **AP 模式需要**：适合对一致性要求不高的场景，可以承担部分服务不可用的风险。

#### Consul

没写关于consul的工作原理，简单列下适用场景：

- **多数据中心**：适合大型分布式系统，尤其是需要在多个数据中心之间提供服务发现和注册的场景。

#### Zookeeper

- 适合对一致性要求非常高的场景，例如分布式协调、分布式锁等。
- **复杂的分布式应用**：在需要严格一致性系统中，如 Hadoop 和 Kafka，Zookeeper 是常见的选择。
