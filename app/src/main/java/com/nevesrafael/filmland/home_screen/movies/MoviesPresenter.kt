package com.nevesrafael.filmland.home_screen.movies

import androidx.lifecycle.lifecycleScope
import com.nevesrafael.filmland.model.MoviesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesPresenter(val screen: MoviesFragment) {

    private val moviesApi = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MoviesApi::class.java)

    fun loadMovies() {
        screen.lifecycleScope.launch {

            screen.showLoading()

            delay(4000) // espera 4 segundos

            val upcoming = withContext(Dispatchers.IO) {
                return@withContext moviesApi.getUpcoming()
            }

            val popular = withContext(Dispatchers.IO) {
                return@withContext moviesApi.getPopular()
            }

            val nowPlaying = withContext(Dispatchers.IO) {
                return@withContext moviesApi.getNowPlaying()
            }

            val topRated = withContext(Dispatchers.IO) {
                return@withContext moviesApi.getTopRated()
            }

            screen.hideLoading()
            screen.showOnScreen(upcoming.results, popular.results, nowPlaying.results, topRated.results)
        }

    }
}