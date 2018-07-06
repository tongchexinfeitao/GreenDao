package com.ali.greendaodemo;

import android.content.Context;

import com.ali.greendaodemo.database.DaoMaster;
import com.ali.greendaodemo.database.DaoSession;

/**
 * Created by mumu on 2018/7/6.
 */

public class DaoManager {
    private static DaoManager daoManager;
    private final DaoSession daoSession;

    private DaoManager(Context context) {
        daoSession = DaoMaster.newDevSession(context, "my.db");
    }

    public static DaoManager instance(Context context) {
        if (daoManager == null) {
            synchronized (DaoManager.class) {
                if (daoManager == null) {
                    daoManager = new DaoManager(context);
                }
            }
        }
        return daoManager;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
