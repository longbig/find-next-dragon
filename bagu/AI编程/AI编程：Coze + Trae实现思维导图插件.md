# AI编程：Coze + Trae实现思维导图插件

> 这是小卷对AI编程工具学习的第3篇文章，今天使用的AI编程是字节新出的Trae，因为才出来不久，用的时候只有Mac版本，今天以生成一个思维导图的浏览器插件为例，试下Trae的效果

## 1.效果展示





## 2.AI编程开发流程

虽然AI编程知识简单对话就行，不过咱要逐步深入到项目开发中，所以还需要前面的需求分析、调研等等步骤，下面是完成一个需求的流程图：

![](/Users/yuyunlong/Pictures/博客/AI编程Trae使用/1.png)

## 3.寻找思维导图Coze插件

我们在Coze的国内站点里搜索能生成思维导图的插件，Coze官网地址：https://www.coze.cn/ ，这里发现TreeMind树图就可以满足我们的需求，输入文字，输出思维导图的图片：

![](/Users/yuyunlong/Pictures/博客/AI编程Trae使用/2.png)

## 4.创建插件测试流程

我们在`工作空间 > 项目开发 > 创建`这样创建一个应用，

![](/Users/yuyunlong/Pictures/博客/AI编程Trae使用/3.png)

然后创建工作流，在工作流中`添加节点`将TreeMind插件添加进来后，再修改下输入输出的变量配置，这样一个工作流就创建好，接着可以手动测试功能是否正常

![](/Users/yuyunlong/Pictures/博客/AI编程Trae使用/4.png)

这里我让其生成一张分布式系统的思维导图，试运行成功后得到图片的链接地址，打开后就是下面的这张图片，能满足我们的需求：

![](/Users/yuyunlong/Pictures/博客/AI编程Trae使用/5.png)

接下来我们将整个流程发布上线，后续的开发编程过程就可以用到了。

点击`发布`按钮，然后发布时选上API

## 5.API参数获取

Coze API的使用是有限制和计费的，基础版本的账户每月只有**100次调用机会**，超过后需要升级成专业版才能付费使用，

Coze API官方文档介绍地址：https://www.coze.cn/open/docs/developer_guides/coze_api_overview

API调用工作流文档地址：https://www.coze.cn/open/docs/developer_guides/workflow_run

### 5.1个人访问令牌

地址：https://www.coze.cn/open/oauth/pats

自行手动创建一个，然后把token拷贝下来，注意只有第一次创建的时候才能看到token

### 5.2 workflow id和app_id的获取

打开应用工作流编辑页面，点击工作流，在浏览器的地址栏里`project-ide`后面跟的数字就是`app_id`，而`workflow`后面的那串数字就是`workflow_id`

![](/Users/yuyunlong/Pictures/博客/AI编程Trae使用/6.png)

### 5.3 在线测试API

我们通过在线测试普通Apifox来测试接口，地址：https://app.apifox.com/

可以将工作流API文档里的示例拷贝出来，在Apifox中选择`导入cURL`的方式新建一个请求，修改对应的参数为自己创建的应用参数，就可以请求执行了，下面是我的请求示例，大家可以自行参考：

```shell
curl --location --request POST 'https://api.coze.cn/v1/workflow/run' \
--header 'Authorization: Bearer pat_npmd******' \
--header 'Content-Type: application/json' \
--data-raw '{
    "workflow_id": "746*****6370",
    "parameters": {
        "input": "生成分布式系统的思维导图"
    },
    "app_id": "74663******692927",
    "is_async": false
}'
```

![](/Users/yuyunlong/Pictures/博客/AI编程Trae使用/7.png)

![](/Users/yuyunlong/Pictures/博客/AI编程Trae使用/8.png)