package com.berlinclock.kata.domain.models

import androidx.compose.ui.graphics.Color
import com.berlinclock.kata.ui.theme.Grey
import com.berlinclock.kata.ui.theme.Red
import com.berlinclock.kata.ui.theme.Yellow

enum class Light(val color: Color) {
    RED(Red),
    YELLOW(Yellow),
    GREY(Grey)
}