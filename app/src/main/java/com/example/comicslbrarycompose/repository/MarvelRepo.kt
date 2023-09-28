package com.example.comicslbrarycompose.repository

import com.example.comicslbrarycompose.di.NetworkModule
import com.example.comicslbrarycompose.model.CharactersApiResponse
import com.example.comicslbrarycompose.model.api.MarvelApi
import com.example.comicslbrarycompose.model.api.NetworkResult
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@ViewModelScoped
class MarvelRepo@Inject constructor(private val api:MarvelApi) {



    val characters=MutableStateFlow<NetworkResult<CharactersApiResponse>>(NetworkResult.Initial())


     fun query(query:String){
        characters.value=NetworkResult.Loading()
        api.getCharacters(query)
            .enqueue(object : Callback<CharactersApiResponse>{
                override fun onResponse(
                    call: Call<CharactersApiResponse>,
                    response: Response<CharactersApiResponse>
                ) {
                   if(response.isSuccessful){
                       response.body()?.let {
                           characters.value=NetworkResult.Success(it)
                       }
                   }
                }

                override fun onFailure(call: Call<CharactersApiResponse>, t: Throwable) {
                   t.localizedMessage.let {
                       characters.value=NetworkResult.Error(it)
                   }
                }

            })
    }


}