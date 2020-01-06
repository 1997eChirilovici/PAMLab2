package com.example.lab2.model;

import java.io.Serializable;

public class Task implements Serializable {

    private String taskName;
    private String taskDueDate;
    private String taskDueTime;
    private String taskNotes;

    public Task(Builder builder) {
        this.taskName = builder.taskName;
        this.taskDueDate = builder.taskDueDate;
        this.taskDueTime = builder.taskDueTime;
        this.taskNotes = builder.taskNotes;
    }

    public static class Builder {
        private String taskName;
        private String taskDueDate;
        private String taskDueTime;
        private String taskNotes;

        public Builder setTaskName(String taskName) {
            this.taskName = taskName;
            return this;
        }

        public Builder setTaskDueDate(String taskDueDate) {
            this.taskDueDate = taskDueDate;
            return this;
        }

        public Builder setTaskDueTime(String taskDueTime) {
            this.taskDueTime = taskDueTime;
            return this;
        }

        public Builder setTaskNotes(String taskNotes) {
            this.taskNotes = taskNotes;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDueDate() {
        return taskDueDate;
    }

    public String getTaskDueTime() {
        return taskDueTime;
    }

    public String getTaskNotes() {
        return taskNotes;
    }
}
