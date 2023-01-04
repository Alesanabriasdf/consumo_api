package com.example.appconsumoapieducacionit

import com.google.gson.annotations.SerializedName

data class DrinksDto(
    @SerializedName("drinks") val listaDeIngredientes: List<Ingredint>
    )

data class Ingredint (
    val strIngredient1 :String
    )
