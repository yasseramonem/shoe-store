package com.yasser.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Shoes (
    var shoeModel: String,
    var shoeCompany: String,
    var shoeSize: String,
    var shoeDesc: String
)

 class ViewModel: ViewModel() {

     val shoesList = mutableListOf(Shoes("", "","",""))

     private val _shoeAdded = MutableLiveData<MutableList<Shoes>>()
     val shoeAdded: LiveData<MutableList<Shoes>>
            get() = _shoeAdded

     init {
         shoesList.clear()

     }

    fun newShoe(){
        _shoeAdded.value = shoesList
    }

}