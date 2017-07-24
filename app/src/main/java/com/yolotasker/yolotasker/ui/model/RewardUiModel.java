package com.yolotasker.yolotasker.ui.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndroidDev on 15.07.2017.
 */

public class RewardUiModel extends BaseUiModel {

    public static List<RewardUiModel> getRewards(){
        List<RewardUiModel> rewardUiModels = new ArrayList<>();
        int price = 10;
        for(int i=0; i<10;i++){
            RewardUiModel rewardUiModel = new RewardUiModel();
            rewardUiModel.setTitle("RewardUiModel title "+i);
            rewardUiModel.setPrice(price);
            price+=10;
            rewardUiModels.add(rewardUiModel);
        }
        return rewardUiModels;
    }
}
