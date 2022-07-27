package com.nevesrafael.filmland.model

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("api_key") key: String = "3454a9d8acef9fe80171ca654cb5d863"
    ): MoviesApiResponse

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("api_key") key: String = "3454a9d8acef9fe80171ca654cb5d863"
    ): MoviesApiResponse
}