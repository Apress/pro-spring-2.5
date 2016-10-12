package com.apress.prospring2.ch17.web;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Aleksa Vukotic
 */

//@Controller
//@RequestMapping("/indexx.html")
public class IndexController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        return new ModelAndView("index", "message", "Hello servlet annotation!");
    }

}