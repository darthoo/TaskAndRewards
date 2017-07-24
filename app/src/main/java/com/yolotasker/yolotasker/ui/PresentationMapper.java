package com.yolotasker.yolotasker.ui;

import android.util.Log;

import com.yolotasker.yolotasker.data.model.Task;
import com.yolotasker.yolotasker.domain.Model.TaskDomainModel;
import com.yolotasker.yolotasker.domain.usecase.impl.TaskUseCaseImpl;
import com.yolotasker.yolotasker.ui.model.TaskUiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class PresentationMapper {

    private static final String TAG = PresentationMapper.class.getSimpleName();

    public static TaskUiModel transformEntity(TaskDomainModel task){
        if(task !=null){
            TaskUiModel taskDomainModel = new TaskUiModel();
            taskDomainModel.setId(task.getId());
            taskDomainModel.setTitle(task.getTitle());
            taskDomainModel.setDescription(task.getDescription());
            taskDomainModel.setPrice(task.getPrice());
            taskDomainModel.setStartDate(task.getStartDate());
            return taskDomainModel;
        } else {
            Log.e(TAG, "Attempt to transform null entity");
            return null;
        }
    }

    public static List<TaskUiModel> transformEntity(List<TaskDomainModel> tasks){
        List<TaskUiModel> uiTasks = new ArrayList<>();
        if(tasks!=null && !tasks.isEmpty()){
            for(TaskDomainModel task: tasks){
                TaskUiModel uiModel = transformEntity(task);
                uiTasks.add(uiModel);
            }
        }
        return uiTasks;
    }
}
