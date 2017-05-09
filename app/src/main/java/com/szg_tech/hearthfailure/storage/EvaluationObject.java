package com.szg_tech.hearthfailure.storage;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class EvaluationObject extends RealmObject {
    @PrimaryKey
    private String key;
    private Boolean booleanValue;
    private Integer intValue;
    private Double doubleValue;
    private Long longValue;
    private String stringValue;
    private RealmList<EvaluationObject> evaluationObject;

    void putValue(Object value) {
        if (value instanceof Boolean) {
            booleanValue = (Boolean) value;
        } else if (value instanceof Integer) {
            intValue = (Integer) value;
        } else if (value instanceof Double) {
            doubleValue = (Double) value;
        } else if (value instanceof Long) {
            longValue = (Long) value;
        } else if (value instanceof String) {
            stringValue = (String) value;
        } else if (value == null) {
            booleanValue = null;
            intValue = null;
            doubleValue = null;
            longValue = null;
            stringValue = null;
        }
//        else if (value instanceof RealmList) {
//            evaluationObject = (RealmList<EvaluationObject>) value;
//        }
    }

    void putKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        if (booleanValue != null) {
            return booleanValue;
        } else if (intValue != null) {
            return intValue;
        } else if (doubleValue != null) {
            return doubleValue;
        } else if (longValue != null) {
            return longValue;
        } else if (stringValue != null) {
            return stringValue;
        }
//        else if (evaluationObject != null) {
//            return evaluationObject;
//        }
        return null;
    }

    String getKey() {
        return key;
    }
}