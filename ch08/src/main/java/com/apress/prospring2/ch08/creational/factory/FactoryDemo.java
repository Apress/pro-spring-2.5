package com.apress.prospring2.ch08.creational.factory;

/**
 * @author janm
 */
public class FactoryDemo {

    private static class Product {

    }

    private static interface Factory {
        Product create();
    }

    private static class SingletonFactory implements Factory {
        private Product product;

        public synchronized Product create() {
            if (this.product == null) {
                product = new Product();
            }
            return product;
        }
    }

    public static void main(String[] args) {
        Factory factory = new SingletonFactory();
        Product p1 = factory.create();
        for (int i = 0; i < 100; i++) {
            if (factory.create() != p1) {
                System.out.println("Factory returned another instance of Product!");
            }
        }
    }

}
