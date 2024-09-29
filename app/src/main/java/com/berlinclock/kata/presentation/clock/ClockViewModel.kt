package com.berlinclock.kata.presentation.clock

import androidx.lifecycle.ViewModel
import com.berlinclock.kata.domain.models.ClockState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class ClockViewModel(): ViewModel() {

    private val _state = MutableStateFlow(ClockState())
    val state: StateFlow<ClockState> = _state

    init {
        startClock()
    }

    private fun startClock() {
        TODO("Not yet implemented")
    }
}