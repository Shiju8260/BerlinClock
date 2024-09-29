package com.berlinclock.kata.presentation.clock

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.berlinclock.kata.domain.models.Light

@Composable
fun Clock(viewModel: ClockViewModel = hiltViewModel(), modifier: Modifier) {
    val state by viewModel.state.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        SecondsLight(state.secondsLight)
        LightsList(state.fiveHoursLight)
        LightsList(state.singleHoursLight)
        Text(
            text = state.time?:"",
            fontSize = 24.sp
        )
    }
}

@Composable
fun SecondsLight(secondsLight: Light?=null) {
    Box(
        modifier = Modifier.padding(bottom = 8.dp).size(50.dp)
            .clip(CircleShape)
            .border(1.dp, Color.DarkGray, CircleShape)
            .background(
                color = secondsLight?.color?: Light.GREY.color
            )
    )
}

@Composable
fun LightsList(lights: ArrayList<Light>?=null) {
    Row (modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)){
        lights?.forEach { light ->
            LightsUi(light.color,Modifier.fillMaxWidth().weight(1f))
        }
    }
}


@Composable
fun LightsUi(color: Color,modifier: Modifier) {
    Box(
        modifier = modifier
            .height(50.dp)
            .clip(RectangleShape)
            .border(1.dp, Color.DarkGray, RectangleShape)
            .background(
                color = color
            )
    )
}
