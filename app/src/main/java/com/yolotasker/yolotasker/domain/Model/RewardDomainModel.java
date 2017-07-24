package com.yolotasker.yolotasker.domain.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndroidDev on 15.07.2017.
 */

public class RewardDomainModel extends BaseDomainModel {

    public static List<RewardDomainModel> getRewards(){
        List<RewardDomainModel> rewards = new ArrayList<>();
        int price = 10;
        for(int i=0; i<10;i++){
            RewardDomainModel reward = new RewardDomainModel();
            reward.setTitle("RewardUiModel title "+i);
            reward.setPrice(price);
            price+=10;
            rewards.add(reward);
        }
        return rewards;
    }
}
