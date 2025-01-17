package com.example.cardinformer.core.data.network

import com.example.cardinformer.core.data.dto.CardInfResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CardInfNetworkClient(
    private val binListApiService: BinListApiService
) : RetrofitNetworkClient() {

    suspend fun execute(): Result<CardInfResponse> =
        withContext(Dispatchers.IO) {
            val result = super.doRequest { binListApiService.getCardInfo("00") }
            result.fold(
                onSuccess = { cardInf ->

                        Result.success(cardInf)

                },
                onFailure = { error ->
                    Result.failure(error)
                }
            )
        }
}
