package com.yolotasker.yolotasker.ui.presenter;

import com.yolotasker.yolotasker.domain.Model.TaskDomainModel;
import com.yolotasker.yolotasker.domain.usecase.TaskUseCase;
import com.yolotasker.yolotasker.domain.usecase.impl.TaskUseCaseImpl;
import com.yolotasker.yolotasker.ui.PresentationMapper;
import com.yolotasker.yolotasker.ui.model.TaskUiModel;
import com.yolotasker.yolotasker.ui.mvp.TaskPresenter;
import com.yolotasker.yolotasker.ui.mvp.TaskView;

import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class TaskPresenterImpl implements TaskPresenter {

    private TaskUseCase taskUseCase;
    private TaskView mView;

    public TaskPresenterImpl(TaskView taskView){
        taskUseCase = new TaskUseCaseImpl();
        mView = taskView;
    }

    @Override
    public void getTasks() {
        List<TaskDomainModel> domainTasks = taskUseCase.getTasks();
        List<TaskUiModel> taskUiModelList = PresentationMapper.transformEntity(domainTasks);
        mView.setTasks(taskUiModelList);
    }

    @Override
    public void addTask(TaskUiModel taskUiModel) {

    }
}
