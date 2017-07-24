package com.yolotasker.yolotasker.domain.usecase;

import com.yolotasker.yolotasker.domain.Model.TaskDomainModel;
import com.yolotasker.yolotasker.ui.model.TaskUiModel;

import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public interface TaskUseCase {

    List<TaskDomainModel> getTasks();

    void addTask(TaskDomainModel taskDomainModel);
}
