package com.example.dh_foods.models.prato

import com.example.dh_foods.models.Pratos
import com.example.dh_foods.models.repository.PratoRepository

class PratoBusiness {

    private val repository: PratoRepository by lazy {
        PratoRepository()
    }

    fun getPratos(): Pratos {
        return repository.getPratos()
    }

}