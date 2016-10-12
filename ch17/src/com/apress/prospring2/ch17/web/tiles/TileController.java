/*
 * Created on 24-Sep-2004
 */
package com.apress.prospring2.ch17.web.tiles;

import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * @author janm
 */
public class TileController extends MultiActionController {

	/**
	 * Holds menu items as String name => String url
	 */
	private Map menu;

	/**
	 * Writes the MemoryPoolMXBean information
	 * 
	 * @param bean The bean
	 * @param writer The writer
	 */
	private void writeMemoryPoolMXBean(MemoryPoolMXBean bean, PrintWriter writer) {
		writer.append("<pre><tt>");

		writer.append("Name: ");
		writer.append(bean.getName());
		writer.append("\n");
		writer.append("Type: ");
		writer.append(bean.getType().name());
		writer.append("\n");
		writer.append("Usage: ");
		writer.append(bean.getUsage().toString());
		writer.append("\n");

		writer.append("</pre></tt>");
	}

	/**
	 * Handles Status tile
	 */
	public ModelAndView handleStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MemoryPoolMXBean> beans = ManagementFactory.getMemoryPoolMXBeans();
		PrintWriter writer = response.getWriter();
		for (MemoryPoolMXBean bean : beans) {
			writeMemoryPoolMXBean(bean, writer);
		}
		return null;
	}

	/**
	 * Handles menu
	 */
	public ModelAndView handleMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new ModelAndView("tile-menu", "menu", menu);
	}

	/**
	 * @param menu The menu to set.
	 */
	public void setMenu(Map menu) {
		this.menu = menu;
	}
}
