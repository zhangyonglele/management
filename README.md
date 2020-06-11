# Mandarin
Project is work for a library. The project provide core function for a library, such as User role management, readers 
borrowing function, income check function, book management function.To support the librarians and library's owner to 
manage the library easier.

The project bases on an the Java platform.

## Table Of Content

- [Environment Preparation](#Environment_Preparation)
- [Install Guide](#Install_Guide)
- [Functions Testing Guide](#Function_Testing_Guide)
- [Contributor](#Contributor)
- [Application Deployment](#Application_Deployment)

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

You can download the release version on our github to easily deploy the server app. Click download to jump to our page.

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
curl http://localhost:8080/bookTypes
```

If you get a response with errorCode 0, that means it runs well.

# Function_Testing_Guide
Enter the url below to test function, the app default open on port 8080.

```shell script
curl localhost:8080/bookTpyes
```

Check system response the format data.

```json
{
    "errorCode": 0,
    "message": "success",
    "data": []
}
```

# Contributor
Data base design and architecture design : Zhang Yongle

Other Developer: Chu Yukang, Guan Bowen, He Jingang

# Application_Deployment
The following guiding will show you how to customize your own config file.

## For application config
Here provide you config file template

```yaml

server:
  
  port: 8080 #Input the port you want to the app run on, the template runs on 8080
  servlet:
    session:
      timeout: 1800s
  tomcat:
    uri-encoding: UTF-8
    protocol-header: x-forwarded-proto
  use-forward-headers: true

## We use Alibaba's OSS server to store img, please input your own OSS config detail
OSS:
  accesskeyId: #input accesskeyId
  accessKeySecret: #input accessKeySecret
  bucketName: #input bucketName
  endpoint: #input endpoint
  bucketURL: #input bucketURL

spring:
  profiles:
    active: online # we use the 'online' configuration below 
  servlet:
    multipart:
      enabled: true
      max-file-size: 5MB

mybatis:
  type-aliases-package: com/lib/management/model
  mapper-locations: classpath:mapping/*.xml

---
spring:
  profiles: online #this configuration is online
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/manage_project?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT
    username: root # input your Database username
    password: Yongle@lol0418 #input your database password
    servlet:
      multipart:
        enabled: true
        max-file-size: 5MB

    http:
      encoding:
        force: true
        charset: utf-8
        enabled: true
    #Redis config
    redis:
      port: 6379 #input the redis port
      host: 127.0.0.1 # input the redis' host ip
      # Redis password
      #password: 123456
      # connection timeout maximum accept 2000ms
      timeout: 2000ms
      jedis:
        pool:
          # Maximum connection pool size
          max-active: 8
          # Maximum blocking time accept, negative number represent no limitation
          max-wait: -1ms
          # Maximum free connection accept
          max-idle: 8
          # Minimum free connection accept
          min-idle: 0
    cache:
      redis:
        ## Entry expiration in milliseconds. By default the entries never expire.
        time-to-live: 1d
        # Writing to Redis need key prefix
        use-key-prefix: true

    session:
      store-type: redis
      timeout: 30M
    jackson:
      time-zone: GMT+8
      date-format: yyyy-MM-dd HH:mm:ss


```

After you finish your own config file, you can run this command to start you own config app.

**PLEASE PUT THE CONFIG FILE IN THE SAME PATH WITH THE .jar APPLICATION**

```shell script
nohup java -jar management-0.0.1-SNAPSHOT.jar --Dspring.config.location=application.properties >management.log 2>&1 &
```

## For Nginx Config
We Also provide you a nginx config file template we edit.

```shell script
# For more information on configuration, see:
#   * Official English Documentation: http://nginx.org/en/docs/
#   * Official Russian Documentation: http://nginx.org/ru/docs/

user nginx;
worker_processes auto;
error_log /var/log/nginx/error.log;
pid /run/nginx.pid;

# Load dynamic modules. See /usr/share/doc/nginx/README.dynamic.
include /usr/share/nginx/modules/*.conf;

events {
    worker_connections 1024;
}

http {
    log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                      '$status $body_bytes_sent "$http_referer" '
                      '"$http_user_agent" "$http_x_forwarded_for"';

    access_log  /var/log/nginx/access.log  main;

    sendfile            on;
    tcp_nopush          on;
    tcp_nodelay         on;
    keepalive_timeout   65;
    types_hash_max_size 2048;

    include             /etc/nginx/mime.types;
    default_type        application/octet-stream;

    # Load modular configuration files from the /etc/nginx/conf.d directory.
    # See http://nginx.org/en/docs/ngx_core_module.html#include
    # for more information.
    include /etc/nginx/conf.d/*.conf;

    ## also put a normal http visiting support
    server{
    		listen 80;
    		server_name #< input your domain name>;
    		root         /usr/share/nginx/html;

    		location / {
        	proxy_pass  #< input your application runs on like  'https://ip:8080'>;
        }

        error_page 404 /404.html;
           location = /40x.html {
        }

        error_page 500 502 503 504 /50x.html;
            location = /50x.html {
        }
    }
    
    # this config is to support https function, it's important
    server {
        listen  443     ssl;
        server_name     ;#please input your domain here
	   client_max_body_size 3M;

        #put your certificat and its key to nginx/conf/ssl
        ssl_certificate         /etc/nginx/ssl/server_cert.crt; 
        ssl_certificate_key     /etc/nginx/ssl/private.key;

        #set session cache's type and size
        ssl_session_cache    shared:SSL:10m;

        #set max timeout to session
        ssl_session_timeout  5m;
        
        location / {
            proxy_pass #< input your application runs on like  'https://ip:8080'>;        
        }
    }
```

```shell script
#do the command below one by one

#stop current nginx config
systemctl stop nginx;

#restart nginx to let new config work
systemctl start nginx;

#check nginx status
systemctl status nginx;
```
if it runs well, ths system will show you the 'active' status



