package com.apress.prospring2.ch14.jruby;

import org.jruby.Ruby;

/**
 * @author janm
 */
public class JRubyDemo {

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
    }

}
