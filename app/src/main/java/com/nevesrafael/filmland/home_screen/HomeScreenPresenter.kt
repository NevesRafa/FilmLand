package com.nevesrafael.filmland.home_screen

import androidx.lifecycle.lifecycleScope
import com.nevesrafael.filmland.model.FilmsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeScreenPresenter(val screen: HomeScreenActivity) {

    private val filmApi = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FilmsApi::class.java)

    fun loadFilms() {
        screen.lifecycleScope.launch {

            val upcoming = withContext(Dispatchers.IO) {
                return@withContext filmApi.getUpcoming()
            }

            screen.showOnScreen(upcoming.results)
        }

    }
}