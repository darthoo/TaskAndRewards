package com.yolotasker.yolotasker.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndroidDev on 15.07.2017.
 */

public class Reward extends BaseModel {

    public static List<Reward> getRewards(){
        List<Reward> rewards = new ArrayList<>();
        int price = 10;
        for(int i=0; i<10;i++){
            Reward reward = new Reward();
            reward.setTitle("RewardUiModel title "+i);
            reward.setPrice(price);
            price+=10;
            rewards.add(reward);
        }
        return rewards;
    }
}
