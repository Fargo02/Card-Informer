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

    @Update
    fun updateCardInf(cardInf: CardInfEntity)

    @Query("SELECT * FROM cardinfentity WHERE bin=:bin")
    fun getCardInfByBin(bin: Int): Flow<CardInfEntity>

    @Delete
    fun delete(cardInf: CardInfEntity)
}