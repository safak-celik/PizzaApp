package com.example.pizzaappforcgi.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PizzaDatabaseDao {
    @Query("SELECT * from pizza_tbl")
    fun getPizzas(): Flow<List<Pizza>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pizza: Pizza)

    @Delete
    suspend fun delete(pizza: Pizza)

}