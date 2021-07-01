package com.yasser.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

 class ViewModel: ViewModel() {

    private val _loggedin_state = MutableLiveData<Boolean>()
    val loggedin_state: LiveData<Boolean>
            get() = _loggedin_state

     private val _shoe_list = MutableLiveData("")
     val shoe_list: LiveData<String>
            get() = _shoe_list


     private val _shoe = mutableListOf("shoe1")



    fun hasLoggedIn(){
        _loggedin_state.value = true
    }

    fun onLogout(){
        _loggedin_state.value = false
    }

}