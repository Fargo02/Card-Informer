package com.example.cardinformer.core.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cardinformer.core.data.source.local.entity.CardInfEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CardInfHistoryDao {

    @Query("SELECT * FROM cardinfentity")
    fun getAllCardInf() : Flow<List<CardInfEntity>>

    @Insert(entity = CardInfEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun addCardInf(cardInf: CardInfEntity)

    @Delete
    fun delete(cardInf: CardInfEntity)
}