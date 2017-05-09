package com.szg_tech.hearthfailure.rest.responses;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by ahmetkucuk on 3/16/17.
 */

public class EvaluationResponse {

    private static final String CODE_SUCCEED = "OK";

    @SerializedName("stat")
    private String status;

    @SerializedName("msg")
    private String message;

    private EvaluationGroup[] outputs;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EvaluationGroup[] getOutputs() {
        return outputs;
    }

    public void setOutputs(EvaluationGroup[] outputs) {
        this.outputs = outputs;
    }

    public boolean isSuccessful(){
        if(status.equalsIgnoreCase(CODE_SUCCEED)) return true;
        return false;
    }

    @Override
    public String toString() {
        return "EvaluationResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", outputs=" + Arrays.toString(outputs) +
                '}';
    }
}
