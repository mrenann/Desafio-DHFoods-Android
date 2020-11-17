package com.example.dh_foods.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dh_foods.models.Restaurantes
import com.example.dh_foods.models.restaurante.RestauranteBusiness

class RestaurantesViewModel : ViewModel(){

    val restaurantesLiveData: MutableLiveData<Restaurantes> = MutableLiveData()
    private val restauranteBusiness = RestauranteBusiness()

    fun getRestaurantes(){
        val restaurantes = restauranteBusiness.getRestaurantes()
        restaurantesLiveData.postValue(restaurantes)
    }


}