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
        val fiveHoursLightList = getFiveHoursLightState(calendar[Calendar.HOUR_OF_DAY])
        val singleHoursLightList = getSingleHoursLightState(calendar[Calendar.HOUR_OF_DAY])
        return ClockState(time = time, secondsLight = secondsLight, fiveHoursLight = fiveHoursLightList, singleHoursLight = singleHoursLightList)
    }

    private fun getSingleHoursLightState(hours: Int): ArrayList<Light> {
        val hoursNumber = (hours%5)-1
        val hoursLight: ArrayList<Light> = arrayListOf(Light.GREY, Light.GREY,Light.GREY,Light.GREY)
        for (i in 0..hoursNumber) {
            hoursLight.set(i,Light.RED)
        }
        return hoursLight
    }

    private fun getFiveHoursLightState(hours: Int): ArrayList<Light> {
        val hourNumber = (hours/5)-1
        val hoursLight: ArrayList<Light> = arrayListOf(Light.GREY, Light.GREY,Light.GREY,Light.GREY)
        for (i in 0..hourNumber) {
            hoursLight.set(i,Light.RED)
        }
        return hoursLight
    }

    private fun getSecondsLightState(seconds: Int): Light {
        return if (seconds % 2 == 0)
            Light.RED
        else
            Light.GREY
    }
}