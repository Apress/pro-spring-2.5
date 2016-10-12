package com.apress.prospring2.ch17.web.views;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Aleksa Vukotic
 */
public class PlainTextView implements View {

    public void render(Map model, HttpServletRequest request,
                       HttpServletResponse response) throws Exception {

        response.setContentType("text/plain");
        response.addHeader("Content-disposition", "attachment; filename=output.txt");

        PrintWriter writer = response.getWriter();
        for (Iterator k = model.keySet().iterator(); k.hasNext();) {
            Object key = k.next();
            writer.print(key);
            writer.println(" contains:");
            writer.println(model.get(key));
        }
    }

    public String getContentType() {
        return "text/plain";
    }
}