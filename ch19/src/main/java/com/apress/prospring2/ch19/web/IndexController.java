package com.apress.prospring2.ch19.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author anirvanc
 */
@Controller
public class IndexController {

	@RequestMapping("/index.html")
	public ModelAndView indexHandler(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws Exception {
		return new ModelAndView();
	}
}
