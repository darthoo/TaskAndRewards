package com.yolotasker.yolotasker.ui.component;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import com.yolotasker.yolotasker.data.TaskRepository;
import com.yolotasker.yolotasker.domain.usecase.TaskUseCase;
import com.yolotasker.yolotasker.ui.fragment.RewardFragment;
import com.yolotasker.yolotasker.ui.fragment.TaskInProgressFragment;
import com.yolotasker.yolotasker.ui.module.ApplicationModule;
import com.yolotasker.yolotasker.ui.mvp.TaskPresenter;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(ActionBarActivity activity);

    void inject(TaskInProgressFragment fragment);

    void inject (RewardFragment fragment);

    Context context();

    TaskRepository taskRepository();

    TaskPresenter taskPresenter();

    TaskUseCase taskUseCase();

}
