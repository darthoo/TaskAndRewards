package com.yolotasker.yolotasker.domain;

import android.util.Log;
import com.yolotasker.yolotasker.data.model.Reward;
import com.yolotasker.yolotasker.data.model.Task;
import com.yolotasker.yolotasker.domain.Model.RewardDomainModel;
import com.yolotasker.yolotasker.domain.Model.TaskDomainModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class DomainMapper {

    private static final String TAG = DomainMapper.class.getSimpleName();

    public static TaskDomainModel transformTask(Task task){
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

    public static List<TaskDomainModel> transformTask(List<Task> tasks){
        List<TaskDomainModel> domainTasks = new ArrayList<>();
        if(tasks!=null && !tasks.isEmpty()){
            for(Task task: tasks){
                TaskDomainModel domainModel = transformTask(task);
                domainTasks.add(domainModel);
            }
        }
        return domainTasks;
    }

    public static RewardDomainModel transformReward(Reward reward){
        if(reward !=null){
            RewardDomainModel rewardDomainModel = new RewardDomainModel();
            rewardDomainModel.setId(reward.getId());
            rewardDomainModel.setTitle(reward.getTitle());
            rewardDomainModel.setPrice(reward.getPrice());
            return rewardDomainModel;
        } else {
            Log.e(TAG, "Attempt to transform null entity");
            return null;
        }
    }

    public static List<RewardDomainModel> transformReward(List<Reward> rewards){
        List<RewardDomainModel> domainRewards = new ArrayList<>();
        if(rewards!=null && !rewards.isEmpty()){
            for(Reward reward: rewards){
                RewardDomainModel domainModel = transformReward(reward);
                domainRewards.add(domainModel);
            }
        }
        return domainRewards;
    }
}
