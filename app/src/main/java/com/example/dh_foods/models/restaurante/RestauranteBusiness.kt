package com.example.dh_foods.models.restaurante

import com.example.dh_foods.models.Restaurantes
import com.example.dh_foods.models.repository.RestauranteRepository

class RestauranteBusiness {

    private val repository: RestauranteRepository by lazy {
        RestauranteRepository()
    }

    fun getRestaurantes(): Restaurantes {
        return repository.getRestaurantes()
    }


}