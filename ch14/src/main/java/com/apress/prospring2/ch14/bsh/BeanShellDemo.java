package com.apress.prospring2.ch14.bsh;

import bsh.Interpreter;

import java.io.StringReader;

/**
 * @author janm
 */
public class BeanShellDemo {

    public static class Bean {
        private String name;
        private int value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private void run() throws Exception {
        Interpreter i = new Interpreter(new StringReader("print(bean.name); bean.value = 20;"),
                System.out, System.err, false);
        Bean bean = new Bean();
        bean.setName("My bean");
        i.set("bean", bean);
        i.run();
        bean = (Bean)i.get("bean");
        System.out.println(bean.getName());
        System.out.println(bean.getValue());
    }

    public static void main(String[] args) throws Exception {
        new BeanShellDemo().run();
    }

}
