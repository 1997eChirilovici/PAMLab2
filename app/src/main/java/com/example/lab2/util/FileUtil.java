package com.example.lab2.util;

import com.example.lab2.model.Task;
import com.example.lab2.repository.PhantomFile;

public class FileUtil {

    private static PhantomFile phantomFile = new PhantomFile();

    public static void saveContentInFile(Task task) {
        phantomFile.addTaskInFile(task);
    }

    public static Task getTaskFormFileByDate(String selectedDate) {
        return phantomFile.getPhantomFile(selectedDate);
    }

    public static void updateTask(Task updatedTask) {
        phantomFile.updateTask(updatedTask);
    }

    public static void removeTask(String deletedDate) {
        phantomFile.removeTask(deletedDate);
    }
}
