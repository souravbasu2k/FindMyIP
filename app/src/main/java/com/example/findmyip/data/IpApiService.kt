package com.example.findmyip.data

import com.example.findmyip.model.IpInfo
import retrofit2.http.GET

interface IpApiService {
    @GET("json")
    suspend fun getIpInfo(): IpInfo
}