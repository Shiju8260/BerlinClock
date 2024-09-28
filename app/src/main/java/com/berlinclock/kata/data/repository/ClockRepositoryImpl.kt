package com.berlinclock.kata.data.repository

import com.berlinclock.kata.domain.models.ClockState
import com.berlinclock.kata.domain.repository.ClockRepository
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ClockRepositoryImpl():ClockRepository {
    private val dateFormat : SimpleDateFormat =  SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    override suspend fun getClockState(date: Date): ClockState {
        val time = dateFormat.format(date)
        return ClockState(time = time)
    }
}