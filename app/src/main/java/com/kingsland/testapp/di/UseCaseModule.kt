package com.kingsland.testapp.di

import com.kingsland.testapp.data.repository.DomainRepository
import com.kingsland.testapp.domain.usecase.GetDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetDataUseCase(
        repository: DomainRepository
    ): GetDataUseCase = GetDataUseCase(repository)
}