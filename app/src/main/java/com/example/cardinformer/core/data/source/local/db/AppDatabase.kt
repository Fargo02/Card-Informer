package com.example.cardinformer.core.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cardinformer.core.data.source.local.dao.CardInfHistoryDao
import com.example.cardinformer.core.data.source.local.entity.CardInfEntity

@Database(entities = [CardInfEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cardInfHistory(): CardInfHistoryDao
}