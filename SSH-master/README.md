# SSH

## SSH整合学习项目
---
```
Spring版本：spring-framework-5.0.3.RELEASE  
Struts2版本：struts-2.5.14.1
Hibernate版本：hibernate-release-5.1.10.Final
```
---
1. Spring和Hibernate整合
    1. 在使用了Transaction情况下session使用getCurrentSession获取时，不需要begin和commit
    2. 如果报如下异常，检查是否在sessionFactory中配置了  current_session_context_class
        ```
        Could not obtain transaction-synchronized Session for current thread
        ```
    3. 全局Spring配置：
        ```
        <context:annotation-config/>
        <context:component-scan base-package="com.mrhu.ssh"/>
        <aop:aspectj-autoproxy/>
        ```
2. Spring和Struts2整合
    1. struts2向Spring拿Action
    2. 引入struts2-spring-plugin
    3. struts2读xml配置文件的顺序
    4. Web.xml中配置Spring的listener
        ```
        <listener>
            <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
        </listener>
        ```
    5. UserAction中userService使用注解注入,使用的时候直接用
    6. 注意Action要使用多例：
        ```
        @Scope("prototype")
        ```
3. DTO一般对应于页面上的一个From
    1. 实现ModelDriven接口
    2. new 出来一个modelDriven
    3. jsp->Action->Dto->Service->Dao->Database
4. 设计
    1. 静态页面
    2. 实体类->数据库表
5. 扩大session的作用时间范围
    1. 使用spring提供的hibernate相关filter
        ```
        org.springframework.orm.hibernate5.support.OpenSessionInViewFilter
        ```
    2. 配置filter时要注意filter的先后顺序，该filter要在struts2前面。
6. 中文问题
    1. struts2配置常量
        ```
        <constant name="struts.i18n.encodeing" value="utf-8"/>
        ```