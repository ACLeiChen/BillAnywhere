package com.example.leichen.billanywhere.di.module;

import android.app.Application;
import android.content.Context;

import com.example.leichen.billanywhere.data.AppDataManager;
import com.example.leichen.billanywhere.data.DataManager;
import com.example.leichen.billanywhere.data.db.AppDbHelper;
import com.example.leichen.billanywhere.data.db.DbHelper;
import com.example.leichen.billanywhere.di.ApplicationContext;
import com.example.leichen.billanywhere.di.DatabaseInfo;
import com.example.leichen.billanywhere.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lei Chen on 2017/4/9.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application mApplication){
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }
}
