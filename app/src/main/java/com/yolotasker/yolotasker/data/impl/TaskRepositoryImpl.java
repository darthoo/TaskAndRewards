package com.yolotasker.yolotasker.data.impl;

import android.content.Context;

import com.yolotasker.yolotasker.data.TaskRepository;
import com.yolotasker.yolotasker.data.db.DBHelper;
import com.yolotasker.yolotasker.data.model.Task;
import com.yolotasker.yolotasker.ui.activity.MainActivity;

import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class TaskRepositoryImpl implements TaskRepository {

    private DBHelper dbHelper;

    public TaskRepositoryImpl() {
        //TODO Implement dependency injection via dagger
        dbHelper = new DBHelper(MainActivity.context);
    }

    @Override
    public List<Task> getTasks() {
        return dbHelper.selectAllTasks();
    }

    @Override
    public void addTask(Task task) {

    }
}
