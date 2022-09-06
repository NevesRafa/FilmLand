package com.nevesrafael.filmland.model

import com.google.gson.annotations.SerializedName

class SeriesApiResponse(
    val page: Int,
    val results: List<SeriesResultsApiResponse>,
    val total_pages: Int,
)

data class SeriesResultsApiResponse(
    val first_air_date: String,
    @SerializedName("genre_ids") val genreIds: ArrayList<Int>,
    val id: Int,
    @SerializedName("name") val title: String,
    val origin_country: ArrayList<String>,
    @SerializedName("original_language") val originalLanguage: String,
    val overview: String,
    val poster_path: String?,
    val vote_average: Double
)


