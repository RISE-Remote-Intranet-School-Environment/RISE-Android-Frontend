package com.example.al4t_claco.Models

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class LoginUIState(
    var name:String,
    var password : String
)



class LoginViewModel: ViewModel() {
    private val _loginUIState = MutableStateFlow(LoginUIState("",""))
    val loginUIState: StateFlow<LoginUIState> = _loginUIState.asStateFlow()

    fun user_authentification(){

    }



}