package com.apress.prospring2.ch12.executor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Jessica
 * Date: 20-Oct-2007
 * Time: 14:03:18
 * To change this template use File | Settings | File Templates.
 */
public class SynchTaskExecutorExample {

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("/com/apress/prospring2/ch12/executor/task-executor-context.xml");

        TaskExecutor taskExecutor = (TaskExecutor) ctx.getBean("synchTaskExecutor", TaskExecutor.class);
        TaskExecutorExample example = new TaskExecutorExample(taskExecutor);
        example.enqueueTasks();
    }
}
