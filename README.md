# Mandarin
Project is work for a library. The project provide core function for a library, such as User role management, readers 
borrowing function, income check function, book management function.To support the librarians and library's owner to 
manage the library easier.

The project bases on an the Java platform.

## Table Of Content

- [Environment Preparation](#Environment_Preparation)
- [Install Guide](#Install_Guide)
- [Functions Testing Guide](#Function Testing Guide)
- [Contributor](#Contributor)
- [Application Deployment](#Application Deployment)

# Environment_Preparation
Before you install the application, you need to prepare the following *Application* or *computer environment*

Please ensure your the *operating system* you will deploy this application is **CentOS7.(and the version above,or linux base system)**

- **JDK11**(Open JDK11)
- **MySQL5.7**(On the deploy Computer)
- **Redis**
- **Nginx**(For https supporting)

After finish the installation, the following operation will help User to install this app on server.

## Write your own Config File
The config file inside of the app is base on the developers' config, you can write your own config file to customize 
the config file on you own Server. And we will give you template of the config file.

## Another way to prepare(Testing config)
And we also show you the development environment configuration to test the system function.

**Remember, the configuration we provide you is not safe for you data, ONLY DO TESTING ON THIS ENVIRONMENT**

- MySQL config
  - username: root
  - password: 168168

- Redis 
  - host: 127.0.0.1
  - port: 6379(default port)

# Install_Guide

After finish the environment preparation, the following operation will guide you to run a quick test to start the 
back end server. [WARN : IT IS NOT OFFICIALLY INSTALL]

- As a developer

If you are a developer for Java Application, you can download source code to compile it on you own. Use Maven to 
package the app.

- As a User or DBA

You can download the release version on our github to easily deploy the serer app. Click download to jump to our page.

[download](https://github.com/zhangyonglele/management/releases)

## Quick Start

First run the SQL file we provide you in MySQL.

When you get the jar file, please put the file on a new dictionary, run the command below(FOR using testing config):

```shell script
nohup java -jar management-0.0.1-SNAPSHOT.jar >management.log 2>&1 &
```

It will Run. Run the command below to check the application whether runs well(TO show the log).

```shell script
tail -f management.log
```

Check the log information :
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.5.RELEASE)

2020-06-02 20:20:56.406  INFO 26918 --- [           main] c.lib.management.ManagementApplication   : Starting ManagementApplication v0.0.1-SNAPSHOT on izbp1hag7tf92dt23mndjez with PID 26918 (/root/project/management-0.0.1-SNAPSHOT.jar started by root in /root/project)
2020-06-02 20:20:56.408  INFO 26918 --- [           main] c.lib.management.ManagementApplication   : The following profiles are active: online
2020-06-02 20:20:58.516  INFO 26918 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
2020-06-02 20:20:58.519  INFO 26918 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Redis repositories in DEFAULT mode.
2020-06-02 20:20:58.595  INFO 26918 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 53ms. Found 0 Redis repository interfaces.
2020-06-02 20:21:01.236  INFO 26918 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-06-02 20:21:01.282  INFO 26918 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-06-02 20:21:01.283  INFO 26918 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.31]
2020-06-02 20:21:01.471  INFO 26918 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-06-02 20:21:01.471  INFO 26918 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 4870 ms
2020-06-02 20:21:04.913  INFO 26918 --- [           main] io.lettuce.core.EpollProvider            : Starting without optional epoll library
2020-06-02 20:21:04.914  INFO 26918 --- [           main] io.lettuce.core.KqueueProvider           : Starting without optional kqueue library
2020-06-02 20:21:06.192  INFO 26918 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-02 20:21:07.707  INFO 26918 --- [           main] s.a.ScheduledAnnotationBeanPostProcessor : No TaskScheduler/ScheduledExecutorService bean found for scheduled processing
2020-06-02 20:21:07.881  INFO 26918 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-06-02 20:21:07.886  INFO 26918 --- [           main] c.lib.management.ManagementApplication   : Started ManagementApplication in 12.802 seconds (JVM running for 13.901)
2020-06-02 21:00:41.299  INFO 26918 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2020-06-02 21:00:41.300  INFO 26918 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2020-06-02 21:00:41.337  INFO 26918 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 37 ms
```

Find the keyword to ensure the application runs well:

```
...

2020-06-02 20:21:07.881  INFO 26918 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-06-02 20:21:07.886  INFO 26918 --- [           main] c.lib.management.ManagementApplication   : Started ManagementApplication in 12.802 seconds (JVM running for 13.901)

...

```

Or run this script:
```shell script
ps aux|grep java
```
Check the application running status.

Run the command below to check if the function work well.

```shell script
curl localhost:8080/bookTypes
```

If you get a response with errorCode 0, that means it runs well.

# Contributor
Data base design and architecture design : Zhang Yongle

Other Developer: Chu Yukang, Guan Bowen, He Jingang