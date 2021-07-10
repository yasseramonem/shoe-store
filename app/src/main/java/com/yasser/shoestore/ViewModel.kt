package com.yasser.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Shoe (
    var shoeModel: String,
    var shoeCompany: String,
    var shoeSize: String,
    var shoeDesc: String
)

 class ViewModel: ViewModel() {

     val shoesList = mutableListOf(Shoe("", "", "", ""))



     private val _shoeAdded = MutableLiveData<MutableList<Shoe>>()
     val shoeAdded: LiveData<MutableList<Shoe>>
            get() = _shoeAdded


     init {
         shoesList.clear()
     }

    fun newShoe(){
        _shoeAdded.value = shoesList

        Log.i("ContentOf ShoeModel", _shoeAdded.value.toString())
    }

}