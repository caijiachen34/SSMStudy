 ch02-requestmaipping:@RequestMapping的使用


实现步骤：
1.新建web maven工程
2.加入依赖
    spring-webmvc依赖，间接吧spring的依赖加入到项目jsp，servlet依赖

3.重点：在web.xml中注册springmvc框架的核心对象DispatcherServlet
    1)DispatcherServlet叫做中央调度器，是一个servlet，他的父类是继承httpservlet
    2)DispatcherServlet页叫做前端控制器（front controller）
    3)DispatcherServlet负责接收用户提交的请求，调用其他的控制器对象，
            并把请求的处理结果显示给用户

4.创建一个发起请求的页面index.jsp

5.创建控制器(处理器)类
    1)在类的上面加入@Controller注解，创建对象，并放入springmvc容器中
    2)在类的方法上面加入@RequestMapping注解

6.创建一个作为结果的jsp，显示请求的处理结果。

7.创建springmvc的配置文件（spring的配置文件一样）
    1)声明组件扫描器，指定@Controller注解所在的包名
    2)声明视图解析器，帮助处理视图

    ---------------------------------------------------------------------------

spring请求的处理流程
    1.发起some.do
    2.tomcat(web.xml-----url-pattern知道*.do的请求给DispatcherServlet)
    3.DispatcherServlet（根据springmvc配置知道 some.do---doSome()）
    4.DispatcherServlet把some.do转发给Mycontroller.doSome方法
    5.框架执行doSome()把得到的ModelAndView进行处理，转发到show.jsp

    上面过程简化
    some.do---DispatcherServlet--MyController
    --------------------------------------------------------------------------

    Springmvc执行过程源代码分析
    1.tomcat启动，创建容器的过程
    通过load-on-start指定的1，创建DispatcherServlet对象，
    DispatcherServlet他的父类是继承HttpServlet的，它是一个servlet，在被创建时，会执行init（）方法。
    在init（）方法中
    //创建容器，读取配置文件
    WebApplicationContext ctx=new ClassPathXmlApplcationContext("springmvc.xml");
    //把容器对象放入到ServletContext中
    getServletContext().getAttribute(key,ctx);

    上面创建容器的作用：创建@Controller注解所咋的类的对象，创建MyController对象，
    这个对象放入到spring的容器中，容器时map，类似map.put("myController",MyController对象)










