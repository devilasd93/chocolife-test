package com.diss.chocolife_test.dagger.modules;

import android.app.Application;

import com.diss.chocolife_test.mvc.controllers.application.MainApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dmitry on 08.09.16.
 */

@Module
public class AppModule {

    private MainApplication application;


    public AppModule(MainApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Application providesApplication(){
        return application;
    }
}
