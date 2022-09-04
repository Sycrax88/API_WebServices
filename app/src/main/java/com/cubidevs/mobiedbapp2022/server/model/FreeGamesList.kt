package com.cubidevs.mobiedbapp2022.server.model


import com.google.gson.annotations.SerializedName

data class FreeGamesList(
    @SerializedName("results")
    val games: List<FreeGame>?= null,
)

