package com.yolotasker.yolotasker.ui;

import android.util.Log;
import com.yolotasker.yolotasker.domain.Model.RewardDomainModel;
import com.yolotasker.yolotasker.domain.Model.TaskDomainModel;
import com.yolotasker.yolotasker.ui.model.RewardUiModel;
import com.yolotasker.yolotasker.ui.model.TaskUiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class PresentationMapper {

    private static final String TAG = PresentationMapper.class.getSimpleName();

    public static TaskUiModel transformTask(TaskDomainModel task){
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

    public static List<TaskUiModel> transformTask(List<TaskDomainModel> tasks){
        List<TaskUiModel> uiTasks = new ArrayList<>();
        if(tasks!=null && !tasks.isEmpty()){
            for(TaskDomainModel task: tasks){
                TaskUiModel uiModel = transformTask(task);
                uiTasks.add(uiModel);
            }
        }
        return uiTasks;
    }

    public static RewardUiModel transformReward(RewardDomainModel reward){
        if(reward !=null){
            RewardUiModel rewardUiModel = new RewardUiModel();
            rewardUiModel.setId(reward.getId());
            rewardUiModel.setTitle(reward.getTitle());
            rewardUiModel.setPrice(reward.getPrice());
            return rewardUiModel;
        } else {
            Log.e(TAG, "Attempt to transform null entity");
            return null;
        }
    }

    public static List<RewardUiModel> transformReward(List<RewardDomainModel> rewards){
        List<RewardUiModel> uiRewards = new ArrayList<>();
        if(rewards!=null && !rewards.isEmpty()){
            for(RewardDomainModel reward: rewards){
                RewardUiModel uiModel = transformReward(reward);
                uiRewards.add(uiModel);
            }
        }
        return uiRewards;
    }
}
