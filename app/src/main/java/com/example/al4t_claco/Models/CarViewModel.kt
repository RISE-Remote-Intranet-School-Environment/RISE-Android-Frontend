package com.example.al4t_claco.Models

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class CarUIState(
    val brand:Int?=null,
    val tires:Int?=null,
    var km:Int = 0
)


class CarViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CarUIState())
    val uiState: StateFlow<CarUIState> = _uiState.asStateFlow()


    fun add_km(km_to_add:Int){
        _uiState.value.km += km_to_add

    }
}