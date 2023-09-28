package com.example.comicslbrarycompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HiltModule{

    // will change here later
    @Provides
    fun provideApiRepo()=MarvelApiRepo(apiService.api)

}