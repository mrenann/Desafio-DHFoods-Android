package com.example.dh_foods.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurante(
        val nome: String,
        val image: String,
        val localizacao: String,
        val fechamento: String,
        val pratoPrincipais: List<Prato> = listOf()
): Parcelable