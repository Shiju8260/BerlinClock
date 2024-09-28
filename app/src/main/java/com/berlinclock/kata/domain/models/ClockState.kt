package com.berlinclock.kata.domain.models

data class ClockState(val time:String?=null,val secondsLight: Light? = null,val fiveHoursLight:ArrayList<Light>? = null,val singleHoursLight:ArrayList<Light>? = null)
