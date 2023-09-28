package com.example.comicslbrarycompose.repository

import com.example.comicslbrarycompose.model.api.MarvelApi
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class MarvelRepo@Inject constructor(private val api:MarvelApi) {





}