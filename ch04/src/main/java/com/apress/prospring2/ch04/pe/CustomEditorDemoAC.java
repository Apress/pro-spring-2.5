package com.apress.prospring2.ch04.pe;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class CustomEditorDemoAC {
    private Complex[] values;

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("/META-INF/spring/pedemo2-context.xml");

        CustomEditorDemoAC bean =
                (CustomEditorDemoAC) factory.getBean("exampleBean");

        System.out.println(bean.sum());
    }

    private Complex sum() {
        Complex result = new Complex(0d, 0d);
        for (Complex value : this.values) {
            result = result.add(value);
        }
        return result;
    }

    public void setValues(Complex[] values) {
        this.values = values;
    }

}