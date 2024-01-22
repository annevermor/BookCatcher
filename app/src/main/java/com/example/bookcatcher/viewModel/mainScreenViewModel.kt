package com.example.bookcatcher.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class MainUiState(
    val number: Int = 0
)

class MainViewModel(): ViewModel(){
    var mainUiState by mutableStateOf(MainUiState())
        private set

    fun reduceNum(){
        mainUiState = MainUiState(
            number = mainUiState.number + 1
        )
    }
}