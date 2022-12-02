package com.example.al4t_claco.Models

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CarUIState(
    val brand: Int? = null,
    val tires: Int? = null,
    var km: Int = 0
)


class CarViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CarUIState())
    val uiState: StateFlow<CarUIState> = _uiState.asStateFlow()


    fun add_km(km_to_add: Int) {
        val oldKm = _uiState.value.km
        _uiState.value = _uiState.value.copy(km = oldKm + km_to_add)

        //val newValue = _uiState.value.apply { km += km_to_add }
        //_uiState.value = newValue

        //_uiState.update { oldState ->
        //    oldState.copy().apply { km += km_to_add }
        //}

    }
}