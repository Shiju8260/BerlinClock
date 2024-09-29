package com.berlinclock.kata.presentation.clock

import com.berlinclock.kata.MainDispatcherRule
import com.berlinclock.kata.domain.models.ClockState
import com.berlinclock.kata.domain.usecase.ClockUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ClockViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var clockViewModel: ClockViewModel

    @Mock
    lateinit var clockUseCase: ClockUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `test time`() = runBlocking {
        val expectedState = ClockState(time = "14:25:32")
        val flow: Flow<ClockState> = flow {
            emit(
                expectedState
            )
        }
        Mockito.`when`(clockUseCase.invoke()).thenReturn(flow)
        clockViewModel = ClockViewModel(clockUseCase)
        Assert.assertEquals(expectedState, clockViewModel.state.value)
    }

}