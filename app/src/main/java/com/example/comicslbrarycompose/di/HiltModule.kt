package com.example.comicslbrarycompose.di

import com.example.comicslbrarycompose.repository.MarvelRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HiltModule{

    // will change here later
    @Provides
    fun provideApiRepo()=MarvelRepo(NetworkModule.api)



}