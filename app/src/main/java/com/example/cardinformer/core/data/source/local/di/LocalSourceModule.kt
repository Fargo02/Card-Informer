package com.example.cardinformer.core.data.source.local.di

import android.content.Context
import androidx.room.Room
import com.example.cardinformer.core.data.repository.LocalDataSourceRepositoryImpl
import com.example.cardinformer.core.data.source.local.LocalDataSource
import com.example.cardinformer.core.data.source.local.RoomLocalDataSource
import com.example.cardinformer.core.data.source.local.db.AppDatabase
import com.example.cardinformer.core.domain.repository.LocalDataSourceRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalSourceModuleProvider {

    @Provides
    fun provideNoteDao(database: AppDatabase) = database.cardInfHistory()

    @Provides
    @Singleton
    fun providesLocalDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "card_inf_history-database"
    ).fallbackToDestructiveMigration().build()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModuleBinder {

    @Binds
    abstract fun bindRoomLocalDataSource(
        roomLocalDataSource: RoomLocalDataSource
    ) : LocalDataSource

    @Binds
    abstract fun bindLocalDaraSourceRepository(
        localDaraSourceRepository: LocalDataSourceRepositoryImpl
    ) : LocalDataSourceRepository
}