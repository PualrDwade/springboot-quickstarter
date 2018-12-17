# 基于SpringBoot的快速启动项目

## 项目简介:nail_care:
springboot-starter是一个整合了springboot rest-api开发过程过常用的基础配置的快速启动项目,减少重复劳动,快速投入生产

## 实践&&整合:alarm_clock:
- 最佳实践的项目结构与配置文件,标准的`MVC`结构
- 集成`swagger-ui`进行高效的`api`管理与前后端协作开发
- 统一响应结果`Result`封装及生成工具,保证开发的规范
- 统一异常处理,使用`serviceException`抛出直接可以用来进行日志记录
- 简单的接口签名认证,实际开发中可以使用spring安全套件
- 集成`lomlok`,减少实体`bean`的getter setter重复代码
- 常用基础方法抽象封装(`service`,`controller`)
- 使用`Druid Spring Boot Starter `集成Druid数据库连接池与监控
- 使用`FastJsonHttpMessageConverter`，提高JSON序列化速度
- 集成`MyBatis`、通用`Mapper`插件、`PageHelper`分页插件，实现单表业务**零**SQL
- 提供代码生成器根据表名生成对应的Model、Mapper、MapperXML、Service、ServiceImpl、Controller等基础代码，其中Controller模板默认提供POST和RESTful两套，根据需求在```CodeGenerator.genController(tableName)```方法中自己选择，默认使用RESTful模板。代码模板可根据实际项目的需求来扩展

## 快速开始:fist_oncoming:
1. 克隆项目`git clone https://github.com/PualrDwade/springboot-quickstarter.git`
2. 进入```test```包内,找到提供的代码生成器```CodeGenerator```对数据库的具体连接参数进行配置,然后对application. properties进行配置(数据库连接用户名密码)
3. 输入表名，运行```CodeGenerator.main()```方法，可以根据模版引擎生成基础代码,生成代码之前请认真设计数据库,确保数据库id字段设计规范(最好不要用int,本项目默认使用了string,尽量不要使用数据库id int自增,而是使用在代码层面的`UUID`等id策略生成唯一的id)
4. 根据业务在基础代码上进行扩展(完全面向接口,需要扩展只需要在接口上增加方法)
5. 对开发环境配置文件```application-dev.properties```进行配置，启动项目

## 开发规范:zap:
- id使用string类型,如果对于id没有要求可以使用UUID生成策略
- 表名，建议使用小写，多个单词使用下划线拼接如(student_course_choose)
- Model内成员变量建议与表字段数量对应，如需扩展成员变量（比如连表查询）建议创建DTO，否则需在扩展的成员变量上加```@Transient```注解，详情见[通用Mapper插件文档说明](https://mapperhelper.github.io/docs/2.use/)
- 建议业务失败直接使用```ServiceException("message")```抛出，由统一异常处理器来封装业务失败的响应结果，比如```throw new ServiceException("该手机号已被注册")```，会直接被封装为```{"code":400,"message":"该手机号已被注册"}```返回，无需自己处理，尽情抛出
- 需要工具类的话建议先从```apache-commons-*```和```guava```中找，实在没有再造轮子或引入类库，尽量精简项目
- 数据库内部一定不要使用外键!!!!一切和外键有关的概念必须在应用层进行业务解决,这样一是方便项目扩大之后的分库分表,二是提高数据库的执行效率,外键是强锁,会大幅度限制速度!!!
- 开发规范建议遵循阿里巴巴Java开发手册([最新版下载](https://github.com/alibaba/p3c))