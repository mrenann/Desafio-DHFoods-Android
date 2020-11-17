package com.example.dh_foods.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val userEmail: String,
    val userName: String,
    val userPass: String
):Parcelable