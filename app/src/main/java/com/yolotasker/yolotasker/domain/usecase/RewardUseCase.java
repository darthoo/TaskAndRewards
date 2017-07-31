package com.yolotasker.yolotasker.domain.usecase;

import com.yolotasker.yolotasker.domain.Model.RewardDomainModel;

import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public interface RewardUseCase {

    List<RewardDomainModel> getRewards();
}
