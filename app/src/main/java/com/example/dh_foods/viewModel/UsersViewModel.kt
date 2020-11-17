package com.example.dh_foods.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dh_foods.models.user.UserBusiness
import com.example.dh_foods.models.Users

class UsersViewModel : ViewModel(){

    private val usersLiveData: MutableLiveData<Users> = MutableLiveData()
    private val userBusiness = UserBusiness()

    fun getUsers(){
        val users = userBusiness.getUsers()
        usersLiveData.postValue(users)
    }


}