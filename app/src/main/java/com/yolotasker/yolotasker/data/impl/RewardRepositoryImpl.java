package com.yolotasker.yolotasker.data.impl;

import com.yolotasker.yolotasker.data.RewardRepository;
import com.yolotasker.yolotasker.data.db.DBHelper;
import com.yolotasker.yolotasker.data.model.Reward;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class RewardRepositoryImpl implements RewardRepository {

    private DBHelper dbHelper;

    @Inject
    public RewardRepositoryImpl(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public List<Reward> getRewards() {
        return dbHelper.selectAllRewards();
    }

}
