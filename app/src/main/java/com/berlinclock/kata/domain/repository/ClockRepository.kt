package com.berlinclock.kata.domain.repository

import com.berlinclock.kata.domain.models.ClockState
import java.util.Date

interface ClockRepository {
    suspend fun getClockState(date: Date): ClockState
}