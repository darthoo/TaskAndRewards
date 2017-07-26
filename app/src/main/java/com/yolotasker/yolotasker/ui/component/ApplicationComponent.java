package com.yolotasker.yolotasker.ui.component;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;

import com.yolotasker.yolotasker.data.TaskRepository;
import com.yolotasker.yolotasker.ui.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(ActionBarActivity activity);

    Context context();

    TaskRepository taskRepository();
}
