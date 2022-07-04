package com.rk.base.data.place_api

import com.rk.base.data.response.DirectionBean
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface PlaceApiService {
    @GET("directions/json")
    suspend fun getDirection(@QueryMap map: Map<String, String>): Response<DirectionBean>
}