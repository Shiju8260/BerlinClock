package com.berlinclock.kata.di

import com.berlinclock.kata.data.repository.ClockRepositoryImpl
import com.berlinclock.kata.domain.repository.ClockRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideClockRepository(
    ): ClockRepository = ClockRepositoryImpl(
    )
}