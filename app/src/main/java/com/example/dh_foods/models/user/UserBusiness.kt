package com.example.dh_foods.models.user

import com.example.dh_foods.models.Users
import com.example.dh_foods.models.repository.UserRepository

class UserBusiness {

    private val repository: UserRepository by lazy {
        UserRepository()
    }

    fun getUsers():Users{
        return repository.getUsers()
    }


}