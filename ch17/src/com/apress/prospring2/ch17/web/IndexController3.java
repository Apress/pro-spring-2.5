package com.apress.prospring2.ch17.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksa Vukotic
 */
public class IndexController3 extends AbstractController {

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        setCacheSeconds(10);
        Map model = new HashMap();
        model.put("Greeting", "Hello World");
        model.put("Server time", new Date());

        View view = (View) getApplicationContext().getBean("plainTextView");

        return new ModelAndView(view, model);
    }

    public String getContentType() {
        return "text/plain";
    }
}
