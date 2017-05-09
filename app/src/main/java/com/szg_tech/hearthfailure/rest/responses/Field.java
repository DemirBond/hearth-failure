package com.szg_tech.hearthfailure.rest.responses;

/**
 * Created by ahmetkucuk on 3/18/17.
 */

public class Field {

    private String par;
    private String val;

    public Field(String par, String val) {
        this.par = par;
        this.val = val;
    }

    public String getPar() {
        return par;
    }

    public void setPar(String par) {
        this.par = par;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Field{" +
                "par='" + par + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}
