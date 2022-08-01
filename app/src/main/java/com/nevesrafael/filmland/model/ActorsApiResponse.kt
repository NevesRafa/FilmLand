package com.nevesrafael.filmland.model

import com.google.gson.annotations.SerializedName

data class ActorsApiResponse(
    val cast: List<ActorsResultsApiResponse>
)

data class ActorsResultsApiResponse(
    val name: String,
    @SerializedName("profile_path") val photo: String,
    val character: String
)