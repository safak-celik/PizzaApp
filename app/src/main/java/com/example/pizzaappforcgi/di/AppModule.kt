package com.example.pizzaappforcgi.di

import android.content.Context
import androidx.room.Room
import com.example.pizzaappforcgi.model.PizzaDatabase
import com.example.pizzaappforcgi.model.PizzaDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providePizzaDao(pizzaDatabase: PizzaDatabase): PizzaDatabaseDao = pizzaDatabase.pizzaDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): PizzaDatabase =
        Room.databaseBuilder(
            context = context,
            klass = PizzaDatabase::class.java,
            name = "pizza_tbl"
        ).fallbackToDestructiveMigration()
            .build()

}