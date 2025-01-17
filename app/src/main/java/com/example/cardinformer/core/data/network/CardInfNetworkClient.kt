package com.example.cardinformer.core.data.network

import com.example.cardinformer.core.data.dto.CardInfResponse

class CardInfNetworkClient(
    private val binListApiService: BinListApiService
) : RetrofitNetworkClient() {

    suspend fun execute(bin: String): Result<CardInfResponse> {
        val result = super.doRequest { binListApiService.getCardInfo(bin) }
        return result.fold(
            onSuccess = { cardInf ->

                Result.success(cardInf)

            },
            onFailure = { error ->
                Result.failure(error)
            }
        )
    }
}
