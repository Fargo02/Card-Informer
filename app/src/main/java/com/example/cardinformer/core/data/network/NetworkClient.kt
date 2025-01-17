package com.example.cardinformer.core.data.network

interface NetworkClient {
    suspend fun <T> doRequest(request: suspend () -> T): Result<T>
}
