package com.example.dh_foods.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Prato(
        val nome: String,
        val image: String,
        val descricao: String
): Parcelable