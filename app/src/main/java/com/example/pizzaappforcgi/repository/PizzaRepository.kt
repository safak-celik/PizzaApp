package com.example.pizzaappforcgi.repository

import com.example.pizzaappforcgi.model.Pizza
import com.example.pizzaappforcgi.model.PizzaDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PizzaRepository @Inject constructor(private val pizzaDatabaseDao: PizzaDatabaseDao) {
    suspend fun addPizza(pizza: Pizza) = pizzaDatabaseDao.insertPizza(pizza)

    suspend fun deletePizza(pizza: Pizza) = pizzaDatabaseDao.deletePizza(pizza)

    fun getAllPizzas(): Flow<List<Pizza>> =
        pizzaDatabaseDao.getPizzas().flowOn(Dispatchers.IO).conflate()
}