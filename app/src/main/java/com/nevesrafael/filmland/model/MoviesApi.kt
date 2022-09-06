package com.nevesrafael.filmland.model

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("api_key") key: String = "3454a9d8acef9fe80171ca654cb5d863",
        @Query("language") language: String = "pt-BR"
    ): HomeItemData

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("api_key") key: String = "3454a9d8acef9fe80171ca654cb5d863",
        @Query("language") language: String = "pt-BR"
    ): HomeItemData

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") key: String = "3454a9d8acef9fe80171ca654cb5d863",
        @Query("language") language: String = "pt-BR"
    ): HomeItemData

    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("api_key") key: String = "3454a9d8acef9fe80171ca654cb5d863",
        @Query("language") language: String = "pt-BR"
    ): HomeItemData

    @GET("movie/{movie_id}/videos")
    suspend fun getTrailer(
        @Path("movie_id") id: Int,
        @Query("api_key") key: String = "3454a9d8acef9fe80171ca654cb5d863",
        @Query("language") language: String = "pt-BR"
    ): TrailerApiResponse

    @GET("movie/{movie_id}/credits")
    suspend fun getActors(
        @Path("movie_id") id: Int,
        @Query("api_key") key: String = "3454a9d8acef9fe80171ca654cb5d863",
        @Query("language") language: String = "pt-BR"
    ): ActorsApiResponse

    @GET("movie/{movie_id}")
    suspend fun getInfo(
        @Path("movie_id") id: Int,
        @Query("api_key") key: String = "3454a9d8acef9fe80171ca654cb5d863",
        @Query("language") language: String = "pt-BR"
    ): MoviesApiResponseTest
}