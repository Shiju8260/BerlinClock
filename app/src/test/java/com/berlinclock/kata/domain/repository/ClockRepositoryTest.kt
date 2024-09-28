package com.berlinclock.kata.domain.repository

import com.berlinclock.kata.data.repository.ClockRepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.Calendar

class CityRepositoryTest {
    private lateinit var clockRepository: ClockRepositoryImpl
    @Before
    fun setUp() {
        clockRepository = ClockRepositoryImpl()
    }
    @Test
    fun `test time state`() = runTest {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        val clockState = clockRepository.getClockState(calendar.time)
        Assert.assertEquals("23:59:59", clockState.time)
    }
}