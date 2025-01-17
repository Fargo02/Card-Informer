package com.example.cardinformer.core.data.network

import com.example.cardinformer.core.data.dto.CardInfResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BinListApiService {

    @GET("{bin}")
    suspend fun getCardInfo(
        @Path("bin") bin: String
    ): CardInfResponse
}