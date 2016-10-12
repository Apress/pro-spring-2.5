package com.apress.prospring2.ch17.web.exception;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionController extends MultiActionController{

    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("defaultErrorView");
    }

    public ModelAndView nullPointerErrorHandler(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("nullPointerErrorView");
    }

    public ModelAndView servletErrorHandler(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("servletErrorView");
    }
}
