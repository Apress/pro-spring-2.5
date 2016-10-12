package com.apress.prospring2.ch06.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class PointcutDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/ataspectjdemo2-context.xml"
        );
        TestBean2 testBean = (TestBean2) ac.getBean("test");
        SimpleBean simpleBean = (SimpleBean) ac.getBean("simple");
        testBean.work();
        testBean.stop();
        simpleBean.sayHello();
        simpleBean.x("a", "b");
    }


}
