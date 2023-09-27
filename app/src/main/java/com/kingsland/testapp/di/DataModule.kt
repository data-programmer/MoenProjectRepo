package com.kingsland.testapp.di

import com.kingsland.testapp.data.source.IDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideDataSource(): IDataSource = IDataSource.create()
}