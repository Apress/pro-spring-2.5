package com.apress.prospring2.ch17.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Aleksa Vukotic
 */

public class IndexController2 extends AbstractController {

    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        setCacheSeconds(10);
        response.getWriter().println("Hello, world at " + System.currentTimeMillis());
        return null;
    }

}