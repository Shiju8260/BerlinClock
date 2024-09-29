package com.berlinclock.kata.presentation.clock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berlinclock.kata.domain.models.ClockState
import com.berlinclock.kata.domain.usecase.ClockUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ClockViewModel @Inject constructor(
    private val clockUseCase: ClockUseCase
): ViewModel() {

    private val _state = MutableStateFlow(ClockState())
    val state: StateFlow<ClockState> = _state

    init {
        startClock()
    }

    private fun startClock() {
        clockUseCase.invoke().onEach { result ->
            _state.value = result
        }.launchIn(viewModelScope)
    }
}