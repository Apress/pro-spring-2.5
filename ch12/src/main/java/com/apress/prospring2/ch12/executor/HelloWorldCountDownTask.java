package com.apress.prospring2.ch12.executor;

public class HelloWorldCountDownTask implements Runnable {

    private String name;
    private int count = 4;

    public HelloWorldCountDownTask(String name) {
        this.name = name;
    }

    public void run() {
        while (count > 0) {
            count--;
            if (count == 0) {
                System.out.print(name + " says 'Hello World!");
                System.out.println(" (current: " +Thread.currentThread().getId() + " / active:"+ Thread.activeCount() + ")");                        
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            } else {
                System.out.print(name + ": " + count);
                System.out.println(" (current: " +Thread.currentThread().getId() + " / active:"+ Thread.activeCount() + ")");
                Thread.yield();
            }
        }
    }
}
