package com.example.pizzaappforcgi.model

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface PizzaDatabaseDao {
    @Query("SELECT * from pizza_tbl")
    fun getPizzas(): Flow<List<Pizza>>

    @Query("SELECT * from pizza_tbl where id = :id")
    suspend fun getPizzaById(id: Int): Pizza

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPizza(pizza: Pizza)

    @Delete
    suspend fun deletePizza(pizza: Pizza)

}