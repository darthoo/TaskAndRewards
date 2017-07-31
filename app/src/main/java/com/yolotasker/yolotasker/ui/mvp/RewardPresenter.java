package com.yolotasker.yolotasker.ui.mvp;

import android.support.annotation.NonNull;

/**
 * Created by AndroidDev on 31.07.2017.
 */

public interface RewardPresenter {

    void getRewards();

    void setView(@NonNull RewardView view);
}
