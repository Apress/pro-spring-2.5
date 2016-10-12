package com.apress.prospring2.ch12.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Java5ThreadPoolExample {

    public static void main(String[] args) {

        /* create a thread pool with two threads */
        ExecutorService service = Executors.newFixedThreadPool(2);

        /* schedule four tasks to be executed */
        service.execute(new HelloWorldCountDownTask("Anna"));
        service.execute(new HelloWorldCountDownTask("Beth"));
        service.execute(new HelloWorldCountDownTask("Charlie"));
        service.execute(new HelloWorldCountDownTask("Daniel"));

        /* prevent further tasks from being added */
        service.shutdown();
    }

}
