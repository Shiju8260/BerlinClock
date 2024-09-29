package com.berlinclock.kata.domain.models

import androidx.compose.ui.graphics.Color
import com.berlinclock.kata.presentation.theme.Grey
import com.berlinclock.kata.presentation.theme.Red
import com.berlinclock.kata.presentation.theme.Yellow

enum class Light(val color: Color) {
    RED(Red),
    YELLOW(Yellow),
    GREY(Grey)
}