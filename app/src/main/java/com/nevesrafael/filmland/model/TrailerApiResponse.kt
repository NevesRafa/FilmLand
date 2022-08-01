package com.nevesrafael.filmland.model

data class TrailerApiResponse(
    val results: List<TrailerResultsApiResponse>
)

class TrailerResultsApiResponse(
    val key: String,
    val site: String
)
