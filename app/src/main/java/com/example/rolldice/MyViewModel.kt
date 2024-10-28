// DiceViewModel.kt
package com.example.rolldice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rolldice.model.DiceModel
import kotlinx.coroutines.*

class DiceViewModel : ViewModel() {

    private val _diceSides = MutableLiveData<DiceModel>()
    val diceSides: LiveData<DiceModel> get() = _diceSides

    private var rollingJob: Job? = null
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun startRolling() {
        rollingJob = coroutineScope.launch {
            while (isActive) {
                _diceSides.value = DiceModel()
                delay(200L)
            }
        }
    }

    fun stopRolling() {
        rollingJob?.cancel()
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}
