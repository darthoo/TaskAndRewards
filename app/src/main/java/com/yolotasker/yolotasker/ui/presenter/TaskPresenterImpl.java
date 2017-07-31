package com.yolotasker.yolotasker.ui.presenter;

import android.support.annotation.NonNull;
import com.yolotasker.yolotasker.domain.Model.TaskDomainModel;
import com.yolotasker.yolotasker.domain.usecase.TaskUseCase;
import com.yolotasker.yolotasker.ui.PresentationMapper;
import com.yolotasker.yolotasker.ui.model.TaskUiModel;
import com.yolotasker.yolotasker.ui.mvp.TaskPresenter;
import com.yolotasker.yolotasker.ui.mvp.TaskView;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class TaskPresenterImpl implements TaskPresenter {

    private TaskUseCase taskUseCase;
    private TaskView mView;

    @Inject
    public TaskPresenterImpl(TaskUseCase taskUseCase){
        this.taskUseCase = taskUseCase;
    }

    @Override
    public void getTasks() {
        List<TaskDomainModel> domainTasks = taskUseCase.getTasks();
        List<TaskUiModel> taskUiModelList = PresentationMapper.transformTask(domainTasks);
        mView.setTasks(taskUiModelList);
    }

    @Override
    public void addTask(TaskUiModel taskUiModel) {

    }

    @Override
    public void setView(@NonNull TaskView view){
        mView = view;
    }
}
