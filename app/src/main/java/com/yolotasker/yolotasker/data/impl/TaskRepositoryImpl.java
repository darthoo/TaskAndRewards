package com.yolotasker.yolotasker.data.impl;

import android.content.Context;

import com.yolotasker.yolotasker.data.TaskRepository;
import com.yolotasker.yolotasker.data.db.DBHelper;
import com.yolotasker.yolotasker.data.model.Task;
import com.yolotasker.yolotasker.ui.activity.MainActivity;

import java.lang.annotation.Inherited;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class TaskRepositoryImpl implements TaskRepository {

    private DBHelper dbHelper;

    @Inject
    public TaskRepositoryImpl(DBHelper dbHelper) {
        //TODO Implement dependency injection via dagger
        this.dbHelper = dbHelper;
    }

    @Override
    public List<Task> getTasks() {
        return dbHelper.selectAllTasks();
    }

    @Override
    public void addTask(Task task) {

    }
}
