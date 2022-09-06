package com.nevesrafael.filmland.model

data class MoviesApiResponseTest(
    // val genres: List<String>,
    val id: Int,
    val original_language: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val runtime: Int,
    val title: String,
    val vote_average: Double,
)