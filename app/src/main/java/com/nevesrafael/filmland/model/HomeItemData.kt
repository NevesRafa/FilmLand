package com.nevesrafael.filmland.model

//fun mapMovie(item: MoviesResultsApiResponse): HomeItemData {
//    val mapeado = HomeItemData(
//        item.poster_path,
//        item.vote_average,
//    )
//
//    return mapeado
//}
//
//fun mapSerie(item: SeriesResultsApiResponse): HomeItemData {
//    val mapeado = HomeItemData(
//        item.poster_path,
//        item.vote_average,
//    )
//
//    return mapeado
//}

data class HomeItemData(
    val results: List<HomeItemDataResults>
)

class HomeItemDataResults(
    val id: Int,
    val poster_path: String?,
    val vote_average: Double,
)
