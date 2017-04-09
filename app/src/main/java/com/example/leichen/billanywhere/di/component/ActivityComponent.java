package com.example.leichen.billanywhere.di.component;

import com.example.leichen.billanywhere.di.PerActivity;
import com.example.leichen.billanywhere.di.module.ActivityModule;
import com.example.leichen.billanywhere.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by Lei Chen on 2017/4/9.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
