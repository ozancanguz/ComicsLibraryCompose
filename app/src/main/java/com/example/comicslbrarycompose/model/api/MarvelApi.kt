package com.example.comicslbrarycompose.model.api

import com.example.comicslbrarycompose.model.CharactersApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("characters")
     fun getCharacters(@Query("nameStartWith")name:String): Call<CharactersApiResponse>



}