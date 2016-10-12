package com.apress.prospring2.ch12.executor;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;

import java.io.IOException;

public class ThreadPoolTaskExecutorExample {

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("/com/apress/prospring2/ch12/executor/task-executor-context.xml");

        TaskExecutor taskExecutor = (TaskExecutor) ctx.getBean("threadPoolTaskExecutor", TaskExecutor.class);
        TaskExecutorExample example = new TaskExecutorExample(taskExecutor);
        example.enqueueTasks();
    }
}
