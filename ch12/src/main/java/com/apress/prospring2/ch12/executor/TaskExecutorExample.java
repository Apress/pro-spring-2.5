package com.apress.prospring2.ch12.executor;

import org.springframework.core.task.TaskExecutor;

public class TaskExecutorExample {

    private TaskExecutor taskExecutor;

    public TaskExecutorExample(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void enqueueTasks() {
        for(int i = 0; i < 25; i++) {
            taskExecutor.execute(new HelloWorldCountDownTask("Task " + i));
        }
    }    
}
