package com.example.pizzaappforcgi.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Pizza::class], version = 1, exportSchema = false)
abstract class PizzaDatabase: RoomDatabase() {
    abstract fun pizzaDao(): PizzaDatabaseDao
}