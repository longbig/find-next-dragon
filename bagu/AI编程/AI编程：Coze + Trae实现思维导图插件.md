# AI编程：Coze + Cursor实现一个思维导图的浏览器插件

> 这是小卷对AI编程工具学习的第3篇文章，今天以实际开发一个思维导图的需求为例，了解AI编程开发的整个过程

## 1.效果展示

![](D:\IdeaProjects\find-next-dragon\bagu\AI编程\AI编程Trae使用\13.png)

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

![](D:\IdeaProjects\find-next-dragon\bagu\AI编程\AI编程Trae使用\7.png)

![](D:\IdeaProjects\find-next-dragon\bagu\AI编程\AI编程Trae使用\8.png)

## 6. Cursor编程集成Coze插件

为了开发生成思维导图的浏览器插件，我们开始逐步操作，第一步，先生成插件的基础框架：

```shell
## 用户故事
用户选中文字，可以显示浮动按钮“生成思维导图”，点击后弹出右侧窗口，显示对应的文字

# 注意：
1.使用manifest v3版本开发
2.注意中文编码问题

# 任务
请按照用户故事和注意点帮我开发谷歌插件
```

![](D:\IdeaProjects\find-next-dragon\bagu\AI编程\AI编程Trae使用\9.png)

接着生成侧边栏的功能

```shell
继续侧边栏的实现：
1.创建一个侧边栏的HTML页面
2.实现在background.js中打开侧边栏的逻辑
3.添加侧边栏的样式
```

![](D:\IdeaProjects\find-next-dragon\bagu\AI编程\AI编程Trae使用\10.png)

可能会出现一些bug问题，我们把bug发给cursor后继续修改完善，下面是框架的效果图，可以看到已经满足我们的需要了，然后可以进行下一步操作了

![](D:\IdeaProjects\find-next-dragon\bagu\AI编程\AI编程Trae使用\11.png)

### 6.1 整合coze API

基于现有代码，现在我们需要整合Coze的API，建议提前把已有功能告诉Cursor，这样也能更好地理解代码背景。输入提示词示例，可结合个人实际情况调整：

```shell
# 目的
用户需求是基于网页选中的内容生成一个思维导图
# 用户故事
用户在网页上选中一段文字，点击浮动按钮，可以生成思维导图的图片，在侧边栏展示
# 生成思维导图的接口
## curl请求的代码
curl --location --request POST 'https://api.coze.cn/v1/workflow/run' \
--header 'Authorization: Bearer 替换为自己的' \
--header 'Content-Type: application/json' \
--data-raw '{
    "workflow_id": "替换为自己的",
    "parameters": {
        "input": "生成分布式系统的思维导图"
    },
    "app_id": "替换为自己的APP_ID"
}'

## 请求参数说明
1. parameters下面的input：网页选中内容

## 返回数据
{
    "code": 0,
    "cost": "0",
    "data": "{\"output\":\"https://static.shutu.cn/shutu/jpeg/opence/2025/02/04/77b63eae2ea61d3******223.jpeg\"}",
    "debug_url": "https://www.coze.cn/work_flow?execute_id=7467838*******",
    "msg": "Success",
    "token": 0
}

## 返回参数说明
1. data下的output为思维导图的图片地址
2.code 状态码，不是0代表出差
3. msg 返回信息

# 注意
1. 注意使用manifest v3版本开发
2. 注意中文编码问题

# 任务
根据 用户故事 和提供的 生成思维导图接口，以及相关注意点，请优化当前谷歌插件
```

![](D:\IdeaProjects\find-next-dragon\bagu\AI编程\AI编程Trae使用\12.png)

![](D:\IdeaProjects\find-next-dragon\bagu\AI编程\AI编程Trae使用\13.png)

最终效果已满足用户需求了！！！

剩下的比如图标不好看等等问题可以自行调整

## 6.总结

今天通过一个实际需求，了解了AI编程的整个开发流程，相信看到最后的读者也能自行学会AI编程。

在AI时代，以后的程序员可能不必再执着于从零开始写代码，学会借助现有工具，运用自己的创意，懂得站在巨人肩膀上，总能看得更远，走得更快