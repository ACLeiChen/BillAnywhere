package com.example.leichen.billanywhere.di.module;

import android.app.Activity;
import android.content.Context;

import com.example.leichen.billanywhere.di.ActivityContext;
import com.example.leichen.billanywhere.di.PerActivity;
import com.example.leichen.billanywhere.ui.main.MainMvpPresenter;
import com.example.leichen.billanywhere.ui.main.MainMvpView;
import com.example.leichen.billanywhere.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Lei Chen on 2017/4/9.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }
}
