package com.example.leichen.billanywhere.data.db;

import android.content.Context;

import com.example.leichen.billanywhere.data.model.DaoMaster;
import com.example.leichen.billanywhere.di.ApplicationContext;
import com.example.leichen.billanywhere.di.DatabaseInfo;
import com.example.leichen.billanywhere.utils.MvpLogger;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Lei Chen on 2017/3/31.
 */

@Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper {

    @Inject
    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        MvpLogger.d("DEBUG", "DB_OLD_VERSION : " + oldVersion + ", DB_NEW_VERSION : " + newVersion);
    }
}
