package com.nevesrafael.filmland.model

import retrofit2.http.GET
import retrofit2.http.Query

interface SeriesApi {

    @GET("tv/airing_today")
    suspend fun getAiringToday(
        @Query("api_key") key: String = "3454a9d8acef9fe80171ca654cb5d863",
        @Query("language") language: String = "pt-BR"
    ): HomeItemData
}