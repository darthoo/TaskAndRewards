package com.yolotasker.yolotasker.ui.mvp;

import com.yolotasker.yolotasker.ui.model.TaskUiModel;

import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public interface TaskView {

    void setTasks(List<TaskUiModel> tasks);
}
