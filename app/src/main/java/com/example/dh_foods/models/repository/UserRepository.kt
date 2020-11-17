package com.example.dh_foods.models.repository

import com.example.dh_foods.models.User
import com.example.dh_foods.models.Users

class UserRepository{

    object UsersLogin {
        var usersList: MutableList<User> = mutableListOf()
    }

    fun getUsers(): Users {
        return Users(
                usersList = UsersLogin.usersList
        )
    }

}