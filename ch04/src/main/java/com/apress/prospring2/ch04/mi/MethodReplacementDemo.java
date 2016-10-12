package com.apress.prospring2.ch04.mi;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StopWatch;

/**
 * @author janm
 */
public class MethodReplacementDemo {

    static interface StressTestCallback {
        String run(ReplacementTarget target);
    }

    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(
                new ClassPathResource("/META-INF/spring/midemo3-context.xml")
        );
        StressTestCallback stringCallback = new StressTestCallback() {
            private final String msg = "Hello";
            
            public String run(ReplacementTarget target) {
                return target.formatMessage(msg);
            }

            @Override
            public String toString() {
                return "formatMessage(String)";
            }
        };
        StressTestCallback objectCallback = new StressTestCallback() {
            private final Object msg = Long.valueOf(1L);

            public String run(ReplacementTarget target) {
                return target.formatMessage(msg);
            }

            @Override
            public String toString() {
                return "formatMessage(Object)";
            }
        };
        stressTest(factory, "replacementTarget", stringCallback);
        stressTest(factory, "standardTarget", stringCallback);
        stressTest(factory, "replacementTarget", objectCallback);
        stressTest(factory, "standardTarget", objectCallback);
    }

    private static void stressTest(XmlBeanFactory factory, String beanName, StressTestCallback callback) {
        ReplacementTarget target = (ReplacementTarget)factory.getBean(beanName);
        System.out.println(callback.run(target));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for (int i = 0; i < 1000000; i++) {
            callback.run(target);
        }
        stopWatch.stop();
        System.out.println("1000000 invocations of formatMessage(" + callback + ") on " + beanName + " took: "
                + stopWatch.getTotalTimeMillis() + " ms");
    }

}
