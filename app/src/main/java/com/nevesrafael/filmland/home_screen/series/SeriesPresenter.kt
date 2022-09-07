package com.nevesrafael.filmland.home_screen.series

import androidx.lifecycle.lifecycleScope
import com.nevesrafael.filmland.model.SeriesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SeriesPresenter(val screen: SeriesFragment) {

    private val seriesApi = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SeriesApi::class.java)

    fun loadSeries() {
        screen.lifecycleScope.launch {

            screen.showLoading()
            delay(4000)

            val airingToday = withContext(Dispatchers.IO) {
                return@withContext seriesApi.getAiringToday()
            }

            val popular = withContext(Dispatchers.IO) {
                return@withContext seriesApi.getPopular()
            }

            val topRated = withContext(Dispatchers.IO) {
                return@withContext seriesApi.getTopRated()
            }

            val onTheAir = withContext(Dispatchers.IO) {
                return@withContext seriesApi.getOnTheAir()
            }

            screen.hideLoading()

            screen.showOnScreen(airingToday.results, popular.results, topRated.results, onTheAir.results)
        }
    }
}