package com.example.lab2.repository;

import com.example.lab2.model.Task;

import java.util.HashMap;
import java.util.Map;

public class PhantomFile {
    private final static Map<String, Task> phantomFile = new HashMap<>();

    public void addTaskInFile(Task newTask) {
        phantomFile.put(newTask.getTaskDueDate(), newTask);
    }

    public Task getPhantomFile(String selectedDate) {
        return phantomFile.get(selectedDate);
    }

    public void updateTask(Task updatedTask) {
        phantomFile.remove(updatedTask.getTaskDueDate());
        phantomFile.put(updatedTask.getTaskDueDate(), updatedTask);
    }

    public void removeTask(String deletedDate) {
        phantomFile.remove(deletedDate);
    }
}
