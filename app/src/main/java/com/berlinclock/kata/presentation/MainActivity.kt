package com.berlinclock.kata.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.berlinclock.kata.presentation.clock.Clock
import com.berlinclock.kata.presentation.theme.BerlinClockTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BerlinClockTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Clock(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
