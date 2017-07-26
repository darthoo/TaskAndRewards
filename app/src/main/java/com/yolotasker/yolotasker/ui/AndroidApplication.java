package com.yolotasker.yolotasker.ui;

import android.app.Application;

import com.yolotasker.yolotasker.ui.component.ApplicationComponent;
import com.yolotasker.yolotasker.ui.component.DaggerApplicationComponent;
import com.yolotasker.yolotasker.ui.module.ApplicationModule;

/**
 * Created by AndroidDev on 26.07.2017.
 */

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
