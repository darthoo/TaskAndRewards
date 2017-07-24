package com.yolotasker.yolotasker.domain.usecase.impl;

import android.support.v7.widget.LinearLayoutManager;

import com.yolotasker.yolotasker.data.TaskRepository;
import com.yolotasker.yolotasker.data.impl.TaskRepositoryImpl;
import com.yolotasker.yolotasker.data.model.Task;
import com.yolotasker.yolotasker.domain.DomainMapper;
import com.yolotasker.yolotasker.domain.Model.TaskDomainModel;
import com.yolotasker.yolotasker.domain.usecase.TaskUseCase;

import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class TaskUseCaseImpl implements TaskUseCase {

    private TaskRepository taskRepository;

    public TaskUseCaseImpl(){
        taskRepository = new TaskRepositoryImpl();
    }

    @Override
    public List<TaskDomainModel> getTasks() {
        List<Task> tasks = taskRepository.getTasks();
        return DomainMapper.transformEntity(tasks);
    }

    @Override
    public void addTask(TaskDomainModel taskDomainModel) {

    }
}
