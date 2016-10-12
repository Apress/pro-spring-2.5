package com.apress.prospring2.ch14.groovy;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

/**
 * @author janm
 */
public class GroovyDemo {

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

    public static void main(String[] args) {
        GroovyShell gs = new GroovyShell();
        Bean bean = new Bean();
        bean.setName("Jan Machacek");
        gs.setVariable("bean", bean);
        Script script = gs.parse("println(bean.name);bean.value = 100;");
        script.run();
        System.out.println(bean.getValue());
    }
}
