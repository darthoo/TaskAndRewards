package com.yolotasker.yolotasker.domain.usecase.impl;

import com.yolotasker.yolotasker.data.RewardRepository;
import com.yolotasker.yolotasker.data.model.Reward;
import com.yolotasker.yolotasker.domain.DomainMapper;
import com.yolotasker.yolotasker.domain.Model.RewardDomainModel;
import com.yolotasker.yolotasker.domain.usecase.RewardUseCase;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class RewardUseCaseImpl implements RewardUseCase {

    private RewardRepository rewardRepository;

    @Inject
    public RewardUseCaseImpl(RewardRepository rewardRepository){
        this.rewardRepository = rewardRepository;
    }

    @Override
    public List<RewardDomainModel> getRewards() {
        List<Reward> rewards = rewardRepository.getRewards();
        return DomainMapper.transformReward(rewards);

    }
}
