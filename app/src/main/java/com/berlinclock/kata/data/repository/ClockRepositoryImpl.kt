package com.berlinclock.kata.data.repository

import com.berlinclock.kata.domain.models.ClockState
import com.berlinclock.kata.domain.models.Light
import com.berlinclock.kata.domain.repository.ClockRepository
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ClockRepositoryImpl():ClockRepository {
    private val dateFormat : SimpleDateFormat =  SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    private val calendar = Calendar.getInstance()

    override suspend fun getClockState(date: Date): ClockState {
        val time = dateFormat.format(date)
        calendar.time = date
        val secondsLight = getSecondsLightState(calendar[Calendar.SECOND])
        return ClockState(time = time, secondsLight = secondsLight)
    }

    private fun getSecondsLightState(seconds: Int): Light {
        return if (seconds % 2 == 0)
            Light.RED
        else
            Light.GREY
    }
}