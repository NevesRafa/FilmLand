package com.nevesrafael.filmland.info_screen

import androidx.lifecycle.lifecycleScope
import com.nevesrafael.filmland.model.ActorsApiResponse
import com.nevesrafael.filmland.model.MoviesApi
import com.nevesrafael.filmland.model.TrailerApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InfoScreenPresenter(val screen: InfoScreenActivity) {

    private val moviesApi = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MoviesApi::class.java)


    fun loadTrailers(movieId: Int) {

        screen.lifecycleScope.launch {

            val trailerResponse = withContext(Dispatchers.IO) {
                return@withContext moviesApi.getTrailer(movieId)
            }

            checkTrailer(trailerResponse)
        }

    }


    fun loadActors(movieId: Int) {
        screen.lifecycleScope.launch {

            val actorsResponse = withContext(Dispatchers.IO) {
                return@withContext moviesApi.getActors(movieId)
            }

            checkActors(actorsResponse)
        }
    }

    fun checkActors(actors: ActorsApiResponse) {
        if (actors.cast.isEmpty()) {

        } else {
            screen.showActors(actors.cast)
        }
    }

    fun checkTrailer(trailer: TrailerApiResponse) {
        if (trailer.results.isEmpty()) {

        } else {
            screen.showTrailer(trailer.results.first().key)
        }
    }

}

