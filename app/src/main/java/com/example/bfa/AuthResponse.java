package com.example.bfa;

import android.provider.ContactsContract;

import androidx.work.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthResponse {

    private Integer code;
    private Boolean success;
    @SerializedName("data")
    @Expose
    private Data data;

    public AuthResponse(Integer code, Boolean success, Data data) {
        this.code = code;
        this.success = success;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}