package com.berlinclock.kata.domain.usecase

import com.berlinclock.kata.data.repository.ClockRepositoryImpl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ClockUseCaseTest {
    private lateinit var clockUseCase: ClockUseCase
    @Before
    fun setUp() {
        clockUseCase = ClockUseCase(ClockRepositoryImpl())
    }
    @Test
    fun `test usecase`() = runTest {
        val clockState =  clockUseCase.invoke().first()
        Assert.assertEquals(true, clockState.time?.isNotEmpty())
    }
}