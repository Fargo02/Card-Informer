package com.example.cardinformer.core.data.network

import com.example.cardinformer.core.data.dto.CardInfResponse

class CardInfNetworkClient(
    private val binListApiService: BinListApiService,
) : RetrofitNetworkClient() {

    suspend fun execute(bin: String): Result<CardInfResponse> =
        super.doRequest { binListApiService.getCardInfo(bin) }
}
