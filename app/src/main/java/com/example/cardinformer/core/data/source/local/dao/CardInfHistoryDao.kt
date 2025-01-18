package com.example.cardinformer.core.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cardinformer.core.data.source.local.entity.CardInfEntity
import com.example.cardinformer.core.domain.model.CardInf
import kotlinx.coroutines.flow.Flow

@Dao
interface CardInfHistoryDao {

    @Query("SELECT * FROM cardinfentity")
    fun getAllCardInf() : Flow<List<CardInfEntity>>

    @Insert
    fun addCardInf(cardInf: CardInfEntity)

    @Delete
    fun delete(cardInf: CardInfEntity)
}