package com.example.comicslbrarycompose.di


import com.example.comicslbrarycompose.model.api.MarvelApi
import com.example.comicslbrarycompose.util.Util.Companion.MARVEL_KEY
import com.example.comicslbrarycompose.util.Util.Companion.MARVEL_SECRET
import com.example.comicslbrarycompose.util.getHash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


object NetworkModule {

    private val BASE_URL="http://gateway.marvel.com/v1/public/"

   private fun getRetrofit():Retrofit{
        val ts=System.currentTimeMillis().toString()
        val apiSecret=MARVEL_SECRET
        val apiKey=MARVEL_KEY
        val hash=getHash(ts,apiSecret,apiKey)

        val clientInterceptor=Interceptor{
            var request:Request=it.request()
            val url:HttpUrl=request.url.newBuilder()
                .addQueryParameter("ts",ts)
                .addQueryParameter("apikey",apiKey)
                .addQueryParameter("hash",hash)
                .build()
            request=request.newBuilder().url(url).build()
            it.proceed(request)
        }

        val client=OkHttpClient.Builder().addInterceptor(clientInterceptor).build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()


    }



  val api:MarvelApi= getRetrofit().create(MarvelApi::class.java)
}