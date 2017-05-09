package com.szg_tech.hearthfailure.storage;

import android.util.Log;

import java.util.List;

import io.realm.RealmModel;

abstract class AbstractDao<T extends RealmModel> {
    private static final String TAG = AbstractDao.class.getSimpleName();
    RealmHelper helper;

    AbstractDao() {
    }

    private String getMyClass() {
        return getClass().getSimpleName();
    }

    void init() {
//        Log.d(TAG, "INIT " + getMyClass() + " " + RealmUtil.dumpRealmIntCount());
        getRealmHelper();
    }

    void beginTransaction() {
        helper.realm.beginTransaction();
    }

    void cancelTransaction() {
        helper.realm.cancelTransaction();
    }

    void commitTransaction() {
        helper.realm.commitTransaction();
    }

    protected void commitTransactionQuietly() {
        try {
            helper.realm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private RealmHelper getRealmHelper() {
        if (helper != null) {
            Log.e(getMyClass(), "Realm was initialized already");
//            throw new IllegalStateException("Realm was initialized already");
        }
        helper = new RealmHelper();
        return helper;
    }

    protected T copyToRealm(T object) {
        return helper.realm.copyToRealm(object);
    }

    public List<T> copyToRealmOrUpdate(List<T> object) {
        return helper.realm.copyToRealmOrUpdate(object);
    }

    protected T copyToRealmOrUpdate(T object) {
        return helper.realm.copyToRealmOrUpdate(object);
    }

    void close() {
        helper.realm.close();
        helper = null;
//        Log.d(TAG, "CLOSE " + getMyClass() + " " + RealmUtil.dumpRealmIntCount());
    }

}
