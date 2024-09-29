package com.berlinclock.kata.domain.usecase

import com.berlinclock.kata.domain.models.ClockState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ClockUseCase {
    operator fun invoke(): Flow<ClockState> =
        flow {
            while (true) {
                delay(1000L)
            }
        }
}