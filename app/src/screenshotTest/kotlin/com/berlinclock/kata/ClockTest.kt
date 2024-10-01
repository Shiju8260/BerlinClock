package com.berlinclock.kata

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.berlinclock.kata.domain.models.ClockState
import com.berlinclock.kata.domain.models.Light
import com.berlinclock.kata.presentation.clock.ClockContent


class ClockTest {

    @Preview(showBackground = true)
    @Composable
    fun ClockPreview() {
       val state =  ClockState(time="11:51:19", secondsLight= Light.GREY, fiveHoursLight= arrayListOf(Light.RED, Light.RED, Light.GREY, Light.GREY), singleHoursLight=arrayListOf(Light.RED, Light.GREY, Light.GREY, Light.GREY), fiveMinutesLight= arrayListOf(Light.YELLOW, Light.YELLOW, Light.RED, Light.YELLOW, Light.YELLOW, Light.RED, Light.YELLOW, Light.YELLOW, Light.RED, Light.YELLOW, Light.GREY), singleMinutesLight= arrayListOf(Light.YELLOW, Light.GREY, Light.GREY, Light.GREY))
        MaterialTheme {
            ClockContent(state= state,modifier = Modifier)
        }
    }
}