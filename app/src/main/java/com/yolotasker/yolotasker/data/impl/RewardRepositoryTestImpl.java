package com.yolotasker.yolotasker.data.impl;

import com.yolotasker.yolotasker.data.RewardRepository;
import com.yolotasker.yolotasker.data.db.DBHelper;
import com.yolotasker.yolotasker.data.model.Reward;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class RewardRepositoryTestImpl implements RewardRepository {

    private DBHelper dbHelper;

    @Inject
    public RewardRepositoryTestImpl(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public List<Reward> getRewards(){
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
