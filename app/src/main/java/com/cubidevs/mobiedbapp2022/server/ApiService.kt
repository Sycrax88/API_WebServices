package com.cubidevs.mobiedbapp2022.server

import com.cubidevs.mobiedbapp2022.server.model.FreeGamesList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("https://www.freetogame.com/api/games\n")
    fun getGames(@Query("api_key") apiKey: String): FreeGamesList

}