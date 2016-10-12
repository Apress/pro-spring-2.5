package com.apress.prospring2.ch12.executor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleAsynchTaskExecutorExample {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "com/apress/prospring2/ch12/executor/task-executor-context.xml");


        TaskExecutorExample example = (TaskExecutorExample) ctx.getBean("simpleAsynchTaskExecutorExample");
        example.enqueueTasks();
    }
}
