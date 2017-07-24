package com.yolotasker.yolotasker.data;

import com.yolotasker.yolotasker.data.model.Task;

import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public interface TaskRepository {

    List<Task> getTasks();

    void addTask(Task task);
}
