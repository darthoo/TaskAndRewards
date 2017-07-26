package com.yolotasker.yolotasker.ui.mvp;

import android.support.annotation.NonNull;

import com.yolotasker.yolotasker.ui.model.TaskUiModel;

import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public interface TaskPresenter {

    void getTasks();

    void addTask(TaskUiModel taskUiModel);

    void setView(@NonNull TaskView view);
}
