package com.cubidevs.mobiedbapp2022.server.freegamesrepository

import com.cubidevs.mobiedbapp2022.server.FreeGameDB

class FreeGamesRepository {

    private var apiKey = "1"

    suspend fun getGames() = FreeGameDB.retrofit.getGames(apiKey)

}