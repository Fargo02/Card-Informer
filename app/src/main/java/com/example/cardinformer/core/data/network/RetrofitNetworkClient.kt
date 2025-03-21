package com.example.cardinformer.core.data.network

import com.example.cardinformer.core.utils.NetworkError
import com.example.cardinformer.core.utils.getConnected
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class RetrofitNetworkClient : NetworkClient {

    override suspend fun <T> doRequest(request: suspend () -> T): Result<T> {
        if (!getConnected()) {
            return Result.failure(NetworkError.NoInternet())
        }
        return withContext(Dispatchers.IO) {
            try {
                Result.success(request())
            } catch (e: HttpException) {
                when (e.code()) {
                    404 -> Result.failure(NetworkError.NoData())
                    else -> Result.failure(NetworkError.ServerError(e.message()))
                }
            }
        }
    }
}
