package com.apress.prospring2.ch08.creational.singleton;

import org.springframework.context.ApplicationContext;

/**
 * @author janm
 */
public class SingletonDemo implements Runnable {

    private interface Checkable {
        void check();
    }

    private static class Singleton1 implements Checkable {
        private static Singleton1 instance;
        private static int instanceCount = 0;
        private Singleton1() {
            try {
                Thread.sleep((long)(Math.random() * 10));
            } catch (InterruptedException e) {
                // impossible
            }
        }

        public static Singleton1 getInstance() {
            if (instance == null) {
                instance = new Singleton1();
                instanceCount++;
            }
            return instance;
        }

        public void check() {
            if (instanceCount > 1) {
                System.out.println(getClass().getName() + " has " + instanceCount + " instance(s)");
            }
        }
    }

    private static class Singleton2 implements Checkable {
        private static Singleton2 instance;
        private static int instanceCount = 0;
        private Singleton2() {
            try {
                Thread.sleep((long)(Math.random() * 10));
            } catch (InterruptedException e) {
                // impossible
            }
        }

        public synchronized static Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
                instanceCount++;
            }
            return instance;
        }

        public void check() {
            if (instanceCount > 1) {
                System.out.println(getClass().getName() + " has " + instanceCount + " instance(s)");
            }
        }
    }

    private static class Singleton3 implements Checkable {
        private static Singleton3 instance = new Singleton3();
        private Singleton3() {
            try {
                Thread.sleep((long)(Math.random() * 10));
            } catch (InterruptedException e) {
                // impossible
            }
        }

        public static Singleton3 getInstance() {
            return instance;
        }

        public void check() {
            // always works!
        }
    }

    public void run() {
        Checkable s1 = Singleton1.getInstance();
        Checkable s2 = Singleton2.getInstance();
        Checkable s3 = Singleton3.getInstance();
        s1.check();
        s2.check();
        s3.check();
    }

    public static void main(String[] args) {
        ApplicationContext ac;
        SingletonDemo me = new SingletonDemo();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(me);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
