package com.yasser.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


open class LoginViewModel: ViewModel() {

    private val _loggedin_state = MutableLiveData(false)
    val loggedin_state: LiveData<Boolean>
            get() = _loggedin_state

    fun onLogin(){
        _loggedin_state.value = true
    }
}