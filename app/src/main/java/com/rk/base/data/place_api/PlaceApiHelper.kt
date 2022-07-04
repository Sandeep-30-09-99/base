package com.rk.base.data.place_api

import com.rk.base.data.response.DirectionBean
import retrofit2.Response

interface PlaceApiHelper {
    suspend fun getDirection(map: Map<String, String>): Response<DirectionBean>
}