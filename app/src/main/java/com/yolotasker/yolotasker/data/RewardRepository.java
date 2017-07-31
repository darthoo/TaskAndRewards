package com.yolotasker.yolotasker.data;

import com.yolotasker.yolotasker.data.model.Reward;

import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public interface RewardRepository {

    List<Reward> getRewards();
}
