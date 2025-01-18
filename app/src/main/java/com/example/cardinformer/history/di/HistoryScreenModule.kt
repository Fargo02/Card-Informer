package com.example.cardinformer.history.di

import com.example.cardinformer.history.domain.usecase.DeleteCardInfUseCase
import com.example.cardinformer.history.domain.usecase.GetAllCardInfUseCase
import com.example.cardinformer.history.domain.usecase.impl.DeleteCardInfUseCaseImpl
import com.example.cardinformer.history.domain.usecase.impl.GetAllCardInfUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HistoryScreenModule {

    @Binds
    abstract fun bindGetAllCardInfUseCase(
        getAllCardInfUseCaseImpl: GetAllCardInfUseCaseImpl
    ): GetAllCardInfUseCase

    @Binds
    abstract fun bindDeleteCardInfUseCase(
        deleteCardInfUseCaseImpl: DeleteCardInfUseCaseImpl
    ): DeleteCardInfUseCase
}