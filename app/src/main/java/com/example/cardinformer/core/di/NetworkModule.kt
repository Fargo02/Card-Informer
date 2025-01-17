package com.example.cardinformer.core.di

import com.example.cardinformer.core.data.network.AuthorizationInterceptor
import com.example.cardinformer.core.data.network.BinListApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BIN_LIST_BASE_URL = "https://lookup.binlist.net/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideHeadHunterApiService(
        okHttpClient: OkHttpClient
    ): BinListApiService {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BIN_LIST_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BinListApiService::class.java)
    }
}