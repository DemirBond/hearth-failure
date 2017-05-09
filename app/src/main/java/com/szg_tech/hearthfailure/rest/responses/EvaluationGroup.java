package com.szg_tech.hearthfailure.rest.responses;

import java.util.Arrays;

/**
 * Created by ahmetkucuk on 3/23/17.
 */

public class EvaluationGroup {

    private String groupname;

    private Field[] fields;


    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Field[] getFields() {
        return fields;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "EvaluationGroup{" +
                "groupname='" + groupname + '\'' +
                ", fields=" + Arrays.toString(fields) +
                '}';
    }
}
