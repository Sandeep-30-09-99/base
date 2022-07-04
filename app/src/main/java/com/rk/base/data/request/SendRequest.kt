package com.rk.base.data.request

import com.google.gson.annotations.SerializedName

class SendRequest<T> {
    @SerializedName("payload")
    var payload: T? = null
}