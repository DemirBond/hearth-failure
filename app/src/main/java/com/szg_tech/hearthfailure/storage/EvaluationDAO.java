package com.szg_tech.hearthfailure.storage;

import com.szg_tech.hearthfailure.core.ConfigurationParams;

import java.util.HashMap;
import java.util.Map;

import io.realm.RealmResults;

public class EvaluationDAO extends AbstractDao<EvaluationObject> {
    private HashMap<String, Object> hashMap = new HashMap<>();
    private static EvaluationDAO instance;

    private EvaluationDAO() {
    }

    public static EvaluationDAO getInstance() {
        if (instance == null) {
            instance = new EvaluationDAO();
        }
        return instance;
    }


    public synchronized HashMap<String, Object> loadValues() {
        init();
        try {
            RealmHelper realmHelper = new RealmHelper();
            RealmResults<EvaluationObject> evaluationObjects = realmHelper.realm.where(EvaluationObject.class).findAll();
            for (EvaluationObject evaluationObject : evaluationObjects) {
                addToHashMap(evaluationObject.getKey(), evaluationObject.getValue());
            }
        } finally {
            close();
        }
        return hashMap;
    }

    public synchronized void saveValues() {
        init();
        try {
            beginTransaction();
            for (String key : hashMap.keySet()) {
                EvaluationObject evaluationObject = helper.realm.where(EvaluationObject.class).equalTo("key", key).findFirst();
                if (evaluationObject == null) {
                    evaluationObject = new EvaluationObject();
                    evaluationObject.putKey(key);
                }
                evaluationObject.putValue(hashMap.get(key));
                helper.realm.copyToRealmOrUpdate(evaluationObject);
            }
            try {
                commitTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                cancelTransaction();
            }
        } finally {
            close();
        }
        hashMap.clear();
    }

    public synchronized boolean isEmpty() {
        init();
        boolean isEmpty = helper.realm.isEmpty();
        close();
        return isEmpty;
    }

    public boolean isMinimumToSaveEntered() {
        boolean isMinimumToSaveEntered = false;
        loadValues();
        if (hashMap.get(ConfigurationParams.NAME) != null
                && hashMap.get(ConfigurationParams.AGE) != null
                && hashMap.get(ConfigurationParams.SBP) != null
                && hashMap.get(ConfigurationParams.DBP) != null) {
            isMinimumToSaveEntered = true;
        }
        return isMinimumToSaveEntered;
    }

    public synchronized void clearEvaluation() {
        hashMap.clear();
        init();
        try {
            beginTransaction();
            helper.realm.delete(EvaluationObject.class);
            try {
                commitTransaction();
            } catch (Exception e) {
                cancelTransaction();
            }
        } finally {
            close();
        }
    }

    public void addToHashMap(String key, Object value) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(key, value);
    }

    public void removeItem(String key) {
        if (hashMap != null) {
            hashMap.remove(key);
        }
        init();
        try {
            beginTransaction();
            helper.realm.where(EvaluationObject.class).equalTo("key", key).findAll().deleteAllFromRealm();
            try {
                commitTransaction();
            } catch (Exception e) {
                cancelTransaction();
            }
        } finally {
            close();
        }
    }

    public void addAllToHashMap(Map<String, Object> newMap) {
        if (this.hashMap == null) {
            this.hashMap = new HashMap<>();
        }
        this.hashMap.putAll(newMap);
    }
}
