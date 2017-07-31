package com.yolotasker.yolotasker.ui.presenter;

import android.support.annotation.NonNull;
import com.yolotasker.yolotasker.domain.Model.RewardDomainModel;
import com.yolotasker.yolotasker.domain.usecase.RewardUseCase;
import com.yolotasker.yolotasker.ui.PresentationMapper;
import com.yolotasker.yolotasker.ui.model.RewardUiModel;
import com.yolotasker.yolotasker.ui.mvp.RewardPresenter;
import com.yolotasker.yolotasker.ui.mvp.RewardView;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by AndroidDev on 24.07.2017.
 */

public class RewardPresenterImpl implements RewardPresenter {

    private RewardUseCase rewardUseCase;
    private RewardView mView;

    @Inject
    public RewardPresenterImpl(RewardUseCase rewardUseCase){
        this.rewardUseCase = rewardUseCase;
    }

    @Override
    public void getRewards() {
        List<RewardDomainModel> domainRewards = rewardUseCase.getRewards();
        List<RewardUiModel> uiRewardList = PresentationMapper.transformReward(domainRewards);
        mView.setRewards(uiRewardList);
    }

    @Override
    public void setView(@NonNull RewardView view){
        mView = view;
    }
}
