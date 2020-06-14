package com.cjc.controller;

import com.cjc.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @RequestMapping:
 * value:所有请求地址的公共部分，叫做模块名称
 * 位置：放在类的上面
 */
@Controller
public class MyController {


    /**
     * 逐个接收请求参数：
     *  要求：处理器(控制器)方法的形参名和请求中参数名必须一致
     *      同名的请求参数赋值给同名的形参
     *  框架接收请求的参数
     *  1.使用request对象接收请求参数
     *      String strName=request.getParameter("name");
     *      String strAge=request.getParameter("age");
     *  2.springmvc框架通过DispatcherServlet调用MyController的doSome方法
     *      调用方法时，按名称对应，把接收的参数赋值给形参
     *      doSome(strname,Integer.valueOf(strAge))
     *      框架会提供类型转换的功能，能把String转为int long fliat double等类型
     *
     *  400状态码：客户端错误，表示提交请求过程中发生的错误
     */
    @RequestMapping(value = {"/receiveproperty.do"})
    public ModelAndView dosome(String name,Integer age){
        //可以在方法中直接使用name，age处理请求some请求了。相当于service调用处理完成了
        System.out.println("doSome,name="+name  + ",age="+age);
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);

        mv.setViewName("show");
        
        return mv;
    }


    /**
     *请求中参数名和处理器方法的形参名不一样
     * @RequestParm：解决请求中参数名和形参名不一样的问题
     *  属性：1.value请求的参数名称
     *      2.required是一个boolean，默认是true
     *          true：表示请求中必须包含此参数
     *  位置：在处理器方法的形参定义的前面
     */
    @RequestMapping(value = {"/receiveparam.do"})
    public ModelAndView receiveparam(@RequestParam(value = "rname",required = false) String name,@RequestParam(value = "rage",required = false) Integer age){
        //可以在方法中直接使用name，age处理请求some请求了。相当于service调用处理完成了
        System.out.println("doSome,name="+name  + ",age="+age);
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);

        mv.setViewName("show");

        return mv;
    }


    /**
     * 处理器形参方法是java对象，这个对象的属性名和请求中参数名一样
     * 框架会创建形参的java对象，给属性赋值。请求中的参数是name，框架会调用setName()
     * @return
     */
    @RequestMapping(value = {"/receiveObject.do"})
    public ModelAndView receiveObject(Student myStudent){
        //可以在方法中直接使用name，age处理请求some请求了。相当于service调用处理完成了
        System.out.println("receiveParam,name="+myStudent.getName()  + ",age="+myStudent.getAge()+"=="+myStudent);
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",myStudent.getName());
        mv.addObject("myage",myStudent.getAge());
        mv.addObject("mystudent",myStudent);

        mv.setViewName("show");

        return mv;
    }


}
