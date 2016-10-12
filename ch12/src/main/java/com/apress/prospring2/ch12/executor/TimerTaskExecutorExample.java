package com.apress.prospring2.ch12.executor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;

import java.io.IOException;

/**
 * User: Jessica
 */
public class TimerTaskExecutorExample {

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("/com/apress/prospring2/ch12/executor/task-executor-context.xml");

        TaskExecutor taskExecutor = (TaskExecutor) ctx.getBean("timerTaskExecutor", TaskExecutor.class);
        TaskExecutorExample example = new TaskExecutorExample(taskExecutor);
        example.enqueueTasks();
    }

}
