package com.nevesrafael.filmland.home_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nevesrafael.filmland.databinding.ActivityHomeScreenBinding
import com.nevesrafael.filmland.model.MoviesResultsApiResponse

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var presenter: HomeScreenPresenter
    private lateinit var upcomingAdapter: UpcomingAdapter
    private lateinit var popularAdapter: PopularMoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = HomeScreenPresenter(this)

        presenter.loadFilms()
        configureRecyclerViewUpcoming()
        configureRecyclerViewPopular()
    }

    private fun configureRecyclerViewPopular() {
        popularAdapter = PopularMoviesAdapter()
        binding.recyclerPopularMovies.adapter = popularAdapter
    }

    private fun configureRecyclerViewUpcoming() {
        upcomingAdapter = UpcomingAdapter()
        binding.recyclerUpcoming.adapter = upcomingAdapter
    }

    fun showOnScreen(
        upcomingResult: List<MoviesResultsApiResponse>,
        popularResult: List<MoviesResultsApiResponse>
    ) {

        upcomingAdapter.update(upcomingResult)
        popularAdapter.update(popularResult)


    }
}