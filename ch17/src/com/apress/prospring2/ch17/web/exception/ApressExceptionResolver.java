package com.apress.prospring2.ch17.web.exception;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ApressExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        Map<String, Object> model = new HashMap<String, Object>();

        model.put("message", ex.getMessage());

        return new ModelAndView("exception", model);
    }
}
