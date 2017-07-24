package com.yolotasker.yolotasker.domain;

import android.util.Log;

import com.yolotasker.yolotasker.data.model.Task;
import com.yolotasker.yolotasker.domain.Model.TaskDomainModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class DomainMapper {

    private static final String TAG = DomainMapper.class.getSimpleName();

    public static TaskDomainModel transformEntity(Task task){
        if(task !=null){
            TaskDomainModel taskDomainModel = new TaskDomainModel();
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

    public static List<TaskDomainModel> transformEntity(List<Task> tasks){
        List<TaskDomainModel> domainTasks = new ArrayList<>();
        if(tasks!=null && !tasks.isEmpty()){
            for(Task task: tasks){
                TaskDomainModel domainModel = transformEntity(task);
                domainTasks.add(domainModel);
            }
        }
        return domainTasks;
    }
}
