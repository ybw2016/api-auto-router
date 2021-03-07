### ------ api自动路由demo------

### 一。实现功能
- 根据产品类型自动识别其抽象工厂，从而将业务层与路由层解耦;
- 当接入了多家产品，想要下线某一家合作方时，可以在路由层将jar包依赖注释掉即可快速下线业务；

### 二。主要类介绍
- RouterNew                     多个策略子类的实现类注解标识
- ServiceFactory                统一策略注册类，Spring启动时扫描所有的策略并加载到内存中;
- ServiceAdapterNew             用户定制的获取bean的方法

### 三。运行说明
- TradeTask                     程序启动后，定时任务自动执行多个策略
- ApiAutoRouterApplication      程序主类
