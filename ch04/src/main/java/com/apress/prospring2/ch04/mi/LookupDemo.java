package com.apress.prospring2.ch04.mi;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StopWatch;

/**
 * @author janm
 */
public class LookupDemo {

    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(
                new ClassPathResource("/META-INF/spring/midemo2-context.xml")
        );
        stressTest(factory, "abstractLookupBean");
        stressTest(factory, "standardLookupBean");
        stressTest(factory, "factoryLookupBean");
    }

    private static void stressTest(XmlBeanFactory factory, String beanName) {
        DemoBean bean = (DemoBean)factory.getBean(beanName);
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();

        System.out.println("Testing " + beanName);
        System.out.println("Helper Instances the Same?: " + (helper1 == helper2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (int i = 0; i < 100000; i++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }

        stopWatch.stop();

        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");

    }

}
