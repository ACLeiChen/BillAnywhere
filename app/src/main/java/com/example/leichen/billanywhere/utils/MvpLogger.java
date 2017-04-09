/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.example.leichen.billanywhere.utils;

import com.example.leichen.billanywhere.BuildConfig;

import timber.log.Timber;


public class MvpLogger {

    public static void init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree(){
                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    return super.createStackElementTag(element) + ":line:" + element.getLineNumber();
                }
            });
        }
    }

    public static void d(String s, Object... args) {
        Timber.d(s, args);
    }

    public static void d(Throwable throwable, String s, Object... args) {
        Timber.d(throwable, s, args);
    }

    public static void i(String s, Object... args) {
        Timber.i(s, args);
    }

    public static void i(Throwable throwable, String s, Object... args) {
        Timber.i(throwable, s, args);
    }

    public static void w(String s, Object... args) {
        Timber.w(s, args);
    }

    public static void w(Throwable throwable, String s, Object... args) {
        Timber.w(throwable, s, args);
    }

    public static void e(String s, Object... args) {
        Timber.e(s, args);
    }

    public static void e(Throwable throwable, String s, Object... args) {
        Timber.e(throwable, s, args);
    }

}
