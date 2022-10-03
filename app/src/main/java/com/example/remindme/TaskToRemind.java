package com.example.remindme;

public class TaskToRemind {
    private String task_name;
    private String task_details;

    public TaskToRemind(String name, String details) {
        task_name = name;
        task_details = details;
    }

    public String getTask_name() {
        return task_name;
    }

    public String getTask_details() {
        return task_details;
    }
}
