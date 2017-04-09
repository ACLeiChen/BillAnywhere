package com.example.leichen.billanywhere.di.component;

import android.app.Application;
import android.content.Context;

import com.example.leichen.billanywhere.BillAnywhereApp;
import com.example.leichen.billanywhere.data.DataManager;
import com.example.leichen.billanywhere.di.ApplicationContext;
import com.example.leichen.billanywhere.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Lei Chen on 2017/4/9.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BillAnywhereApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
