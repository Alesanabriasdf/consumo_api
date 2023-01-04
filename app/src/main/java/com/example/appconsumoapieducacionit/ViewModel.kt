package com.example.appconsumoapieducacionit

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {

    val ingredients = MutableLiveData<List<String>>()
    val ingredientList = mutableListOf<String>()
    val error = MutableLiveData<Boolean>()

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {

        viewModelScope.launch(Dispatchers.IO){

            try {
                val lista = marsApi.retrofitService.getPhotos()
                lista.body()?.listaDeIngredientes?.forEach{
                    ingredientList.add(it.strIngredient1)
                    ingredients.postValue(ingredientList)
                }
            } catch (e: Exception){
                error.postValue(true)
            }
        }
    }
}