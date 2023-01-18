package com.qantas.test.arch.api

import com.qantas.test.model.QantasData
import retrofit2.http.GET

/**
 * [QantasDataApi] interface contains api calls related to Qantas module.
 */
interface QantasDataApi {
    companion object {
        const val BASE_URL = "https://api.qantas.com/flight/refData/"
    }

    @GET("airport")
    suspend fun retrieveQantasData(): List<QantasData>

}