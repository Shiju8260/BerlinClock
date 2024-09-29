package com.berlinclock.kata.domain.usecase

import com.berlinclock.kata.domain.models.ClockState
import com.berlinclock.kata.domain.repository.ClockRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date
import javax.inject.Inject

class ClockUseCase @Inject constructor(
   private val clockRepository: ClockRepository
) {
    operator fun invoke(): Flow<ClockState> =
        flow {
            while (true) {
                emit(clockRepository.getClockState(Date()))
                delay(1000L)
            }
        }
}