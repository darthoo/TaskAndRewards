package com.yolotasker.yolotasker.domain.usecase.impl;

import com.yolotasker.yolotasker.data.TaskRepository;
import com.yolotasker.yolotasker.data.model.Task;
import com.yolotasker.yolotasker.domain.DomainMapper;
import com.yolotasker.yolotasker.domain.Model.TaskDomainModel;
import com.yolotasker.yolotasker.domain.usecase.TaskUseCase;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class TaskUseCaseImpl implements TaskUseCase {

    private TaskRepository taskRepository;

    @Inject
    public TaskUseCaseImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskDomainModel> getTasks() {
        List<Task> tasks = taskRepository.getTasks();
        return DomainMapper.transformTask(tasks);
    }

    @Override
    public void addTask(TaskDomainModel taskDomainModel) {

    }
}
