package com.rk.base.di.base;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse {
    @SerializedName("code")
    String code;
    @SerializedName("message")
    String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}