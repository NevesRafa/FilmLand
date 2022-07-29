package com.nevesrafael.filmland.model

import com.google.gson.annotations.SerializedName

data class MoviesApiResponse(
    val results: List<MoviesResultsApiResponse>
)

data class MoviesResultsApiResponse(
    @SerializedName("genre_ids") val genreIds: ArrayList<Int>,
    val id: Int,
    @SerializedName("original_language") val originalLanguage: String,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val vote_average: Double,
    val vote_count: Int
)
