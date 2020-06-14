package com.cjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/test")
public class MyController {

    /**
     * @RequestMapping请求映射
     *      属性：method，表示请求的方式。他的值是RequestMethod类枚举值
     *      例如：表示get请求方式，RequestMethod.GET
     *          post方式，RequestMethod.POST
     *
     * 不用get方式，错误是：
     * HTTP：405 - Request method ‘GET’ not supported
     */
    //指定some.do使用get请求方式
    @RequestMapping(value = {"/some.do"},method = RequestMethod.GET)
    public ModelAndView dosome(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","111欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的是doSome方法");

        mv.setViewName("show");
        
        return mv;
    }

    //指定other.do为other请求方式
    @RequestMapping(value = {"/other.do","/second.do"},method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","222欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的是doOther方法");
        mv.setViewName("other");
        return mv;
    }


    //不指定请求方式
    @RequestMapping(value = "/first.do")
    public ModelAndView doFirst(HttpServletRequest request,
                                HttpServletResponse response,
                                HttpSession session){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","222欢迎使用springmvc做web开发222"+request.getParameter("name"));
        mv.addObject("fun","执行的是doFirst方法");
        mv.setViewName("other");
        return mv;
    }
}
