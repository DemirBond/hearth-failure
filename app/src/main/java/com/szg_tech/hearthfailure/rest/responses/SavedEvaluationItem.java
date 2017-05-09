package com.szg_tech.hearthfailure.rest.responses;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ahmetkucuk on 4/5/17.
 */

public class SavedEvaluationItem {


    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private final SimpleDateFormat userFriendlyFormat = new SimpleDateFormat("EEE M/dd HH:mm");

    @SerializedName("ID")
    private int id;

    @SerializedName("isPAH")
    private int isPAH;

    @SerializedName("Name")
    private String name;


    @SerializedName("createdate")
    private String createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsPAH() {
        return isPAH;
    }

    public void setIsPAH(int isPAH) {
        this.isPAH = isPAH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUserFriendlyDateString() {
        try {
            Date date = simpleDateFormat.parse(getCreateDate());
            return userFriendlyFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return createDate;
    }

    @Override
    public String toString() {
        return "SavedEvaluationItem{" +
                "id=" + id +
                ", isPAH=" + isPAH +
                ", name='" + name + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
