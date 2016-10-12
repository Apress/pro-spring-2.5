package com.apress.prospring2.ch04.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * @author janm
 */
public class MessageSourceDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "/META-INF/spring/acdemo3-context.xml");
        
        Locale english = Locale.ENGLISH;
        Locale czech = new Locale("cs", "CZ");

        System.out.println(ctx.getMessage("msg", null, english));
        System.out.println(ctx.getMessage("msg", null, Locale.UK));
        System.out.println(ctx.getMessage("msg", null, czech));
        System.out.println(ctx.getMessage("hello", null, Locale.UK));

        System.out.println(ctx.getMessage("nameMsg",
                new Object[] { "Jan", "Machacek" }, english));
    }

}
