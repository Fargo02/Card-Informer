package com.example.cardinformer.home.di

import com.example.cardinformer.home.domain.usecase.GetCardInfUseCase
import com.example.cardinformer.home.domain.usecase.impl.GetCardInfUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeScreenModule {

    @Binds
    abstract fun bindGetCardInformationUseCase(
        getCardInformationUseCaseImpl: GetCardInfUseCaseImpl
    ): GetCardInfUseCase
}