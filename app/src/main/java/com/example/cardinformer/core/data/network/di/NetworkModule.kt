package com.example.cardinformer.core.data.network.di

import com.example.cardinformer.core.data.repository.CardInfRepositoryImpl
import com.example.cardinformer.core.data.network.AuthorizationInterceptor
import com.example.cardinformer.core.data.network.BinListApiService
import com.example.cardinformer.core.data.network.CardInfNetworkClient
import com.example.cardinformer.core.domain.repository.CardInfRepository
import dagger.Binds
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
object NetworkModuleProvider {

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

    @Provides
    @Singleton
    fun provideCardInfNetworkClient(
        binListApiService: BinListApiService
    ): CardInfNetworkClient {
        return CardInfNetworkClient(binListApiService)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModuleBinder() {

    @Binds
    abstract fun bindCardInfRepository(
        cardInfRepositoryImpl: CardInfRepositoryImpl
    ): CardInfRepository
}

