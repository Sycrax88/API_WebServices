package com.cubidevs.mobiedbapp2022.server.moviesrepository

import com.cubidevs.mobiedbapp2022.server.MovieDB

class MoviesRepository {

    private var apiKey = "ca4f52cceb094c6ca8a59c8232334d2d"

    suspend fun getMovies() = MovieDB.retrofit.getMovies(apiKey)

}