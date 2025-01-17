package com.example.cardinformer.core.data.network

import okhttp3.Interceptor
import okhttp3.Response

object AuthorizationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header("Accept-Version", "3")
            .build()
        return chain.proceed(request)
    }

}
