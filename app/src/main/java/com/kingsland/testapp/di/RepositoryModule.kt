package com.kingsland.testapp.di

import com.kingsland.testapp.data.repository.DomainRepository
import com.kingsland.testapp.data.source.IDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        dataSource: IDataSource
    ): DomainRepository = DomainRepository(dataSource)
}