/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yolotasker.yolotasker.ui.module;

import android.content.Context;
import com.yolotasker.yolotasker.data.TaskRepository;
import com.yolotasker.yolotasker.data.db.DBHelper;
import com.yolotasker.yolotasker.data.impl.TaskRepositoryImpl;
import com.yolotasker.yolotasker.domain.usecase.TaskUseCase;
import com.yolotasker.yolotasker.domain.usecase.impl.TaskUseCaseImpl;
import com.yolotasker.yolotasker.ui.AndroidApplication;
import com.yolotasker.yolotasker.ui.mvp.TaskPresenter;
import com.yolotasker.yolotasker.ui.presenter.TaskPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
  private final AndroidApplication application;

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides @Singleton
  Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton
  TaskRepository provideTaskRepository(DBHelper dbHelper) {
    return new TaskRepositoryImpl(dbHelper);
  }

  @Provides @Singleton
  TaskPresenter provideTaskPresenter(TaskUseCase taskUseCase) {
    return new TaskPresenterImpl(taskUseCase);
  }

  @Provides @Singleton
  TaskUseCase providesTaskUseCase(TaskRepository taskRepository){
    return new TaskUseCaseImpl(taskRepository);
  }
}
