package com.szg_tech.hearthfailure.storage;

import android.support.annotation.Nullable;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmHelper {
    private static String userName = "anonymous";
    public final Realm realm;
    private RealmConfiguration realmConfig;
    private static final String TAG = RealmHelper.class.getSimpleName();
    private static final int SCHEMA_VERSION = 1;

    private static final byte[] FINAL_ENCRYPTED_KEY = "9gz55fIBar3Xcc1ZoKoWTI8AqqZzxazavvXbrHHd8RS5eWwviPRr0LVWqAiE2m02".getBytes();


    public RealmHelper() {
        realmConfig = new RealmConfiguration.Builder()
                .name(userName)
                .encryptionKey(FINAL_ENCRYPTED_KEY)
                .schemaVersion(SCHEMA_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(realmConfig);
    }

    /**
     * Allow to have db per user.
     *
     * @param userName used as filename for DB
     */
    public static void setUserName(@Nullable String userName) {
        if (userName == null) {
            userName = "anonymous";
        }
        RealmHelper.userName = userName;
    }

    //Common methods

    public static int getIdNumber(Class clazz, Realm realm) {
        Number number = realm.where(clazz).max("id");
        return number != null ? number.intValue() + 1 : 0;
    }
}
