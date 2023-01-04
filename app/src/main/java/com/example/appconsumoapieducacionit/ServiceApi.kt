package com.example.appconsumoapieducacionit

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("https://thecocktaildb.com/")
    .build()

interface MarsApiService{
    @GET("api/json/v1/1/list.php?i=list")
    suspend fun getPhotos(): Response<DrinksDto>
}

object marsApi{
    val retrofitService : MarsApiService by lazy { retrofit.create(MarsApiService::class.java)   }
}
