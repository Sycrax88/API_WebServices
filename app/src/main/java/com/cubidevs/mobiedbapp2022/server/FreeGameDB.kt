package com.cubidevs.mobiedbapp2022.server

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FreeGameDB {

    private const val  urlAPI="https://www.freetogame.com/api/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor((HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)))
        .build()

    val retrofit: ApiService = Retrofit.Builder()
        .baseUrl(urlAPI)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .run {
            create(ApiService::class.java)
        }
}