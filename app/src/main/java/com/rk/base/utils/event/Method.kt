package com.rk.base.utils.event

import com.rk.base.di.base.SimpleApiResponse
import retrofit2.Response

abstract class Method<T> {
    open suspend fun getSimpleApiMethod(token: String?): Response<SimpleApiResponse<T>>? {
        return null
    }

}