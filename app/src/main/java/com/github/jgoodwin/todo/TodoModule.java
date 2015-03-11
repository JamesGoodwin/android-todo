package com.github.jgoodwin.todo;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class TodoModule {
    private final Application application;

    TodoModule(Application application) {
        this.application = application;
    }

//    @Provides
//    @Singleton
//    Application provideApplication() {
//        return application;
//    }
}