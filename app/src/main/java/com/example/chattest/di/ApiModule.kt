package com.example.chattest.di

import com.example.chattest.data.repository.MockRepositoryImpl
import com.example.chattest.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideRepository(): Repository {
        return MockRepositoryImpl()
    }


}