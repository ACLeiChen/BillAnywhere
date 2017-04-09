package com.example.leichen.billanywhere;

import android.app.Application;

import com.example.leichen.billanywhere.data.DataManager;
import com.example.leichen.billanywhere.di.component.ApplicationComponent;
import com.example.leichen.billanywhere.di.component.DaggerApplicationComponent;
import com.example.leichen.billanywhere.di.module.ApplicationModule;
import com.example.leichen.billanywhere.utils.MvpLogger;

import javax.inject.Inject;

/**
 * Created by Lei Chen on 2017/4/9.
 */

public class BillAnywhereApp extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    //private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        MvpLogger.init();

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
