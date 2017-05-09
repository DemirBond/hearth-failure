package com.szg_tech.hearthfailure.rest.responses;

import com.google.gson.annotations.SerializedName;
import com.szg_tech.hearthfailure.core.ConfigurationParams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ahmetkucuk on 4/6/17.
 */

public class SavedEvaluationResponse extends BaseResponse {


    @SerializedName("isPAH")
    private int isPAH;

    @SerializedName("createdate")
    private String createDate;

    @SerializedName("Name")
    private String name;

    @SerializedName("age")
    private Double age;

    @SerializedName("gender")
    private Double gender;

    @SerializedName("SBP")
    private Double SBP;

    @SerializedName("DBP")
    private Double DBP;

    @SerializedName("rest")
    private String rest;


    /**
     *
     * This method parse "inputs" value coming from server
     * It apply some arranged rules.
     * E.g. Boolean values only appears
     * E.g. Male mapped to 1 Female mapped to 2
     *
     *
     * Since we cannot enforce changes in server side
     * we need to live this these boilerplate codes.
     *
     *
     * @return evaluation item key by value
     */
    public Map<String, Object> parseEvaluationInputs() {
        Map<String, Object> map = new HashMap<>();

        map.put(ConfigurationParams.NAME, name);
        map.put(ConfigurationParams.AGE, age);
        map.put(ConfigurationParams.GENDER, gender);
        map.put(ConfigurationParams.SBP, SBP);
        map.put(ConfigurationParams.DBP, DBP);
        map.put(ConfigurationParams.IS_PAH, ((isPAH == 1) ? true:false));

        if(rest == null || rest.isEmpty()) return map;

        String[] values = rest.split("\\|");
        System.out.println(Arrays.toString(values));

        for(String s: values) {
            if(s.contains("=")) {
                String[] pair = s.split("=");

                try{
                    map.put(pair[0], Double.valueOf(pair[1]));
                }catch (NumberFormatException e){
                    e.printStackTrace();
                    map.put(pair[0], pair[1]);
                }

            } else if(s.length() >= 3 && s.substring(0, 3).equalsIgnoreCase("chk")) {
                map.put(s, true);
            }
        }
        return map;
    }


    public int getIsPAH() {
        return isPAH;
    }

    public void setIsPAH(int isPAH) {
        this.isPAH = isPAH;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Double getGender() {
        return gender;
    }

    public void setGender(Double gender) {
        this.gender = gender;
    }

    public Double getSBP() {
        return SBP;
    }

    public void setSBP(Double SBP) {
        this.SBP = SBP;
    }

    public Double getDBP() {
        return DBP;
    }

    public void setDBP(Double DBP) {
        this.DBP = DBP;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }
}
