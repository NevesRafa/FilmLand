package com.nevesrafael.filmland.home_screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nevesrafael.filmland.databinding.ActivityHomeScreenBinding
import com.nevesrafael.filmland.info_screen.InfoScreenActivity
import com.nevesrafael.filmland.model.MoviesResultsApiResponse

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var presenter: HomeScreenPresenter
    private lateinit var homeScreenAdapter: HomeScreenAdapter
    private lateinit var popularAdapter: HomeScreenAdapter
    private lateinit var nowPlayingAdapter: HomeScreenAdapter
    private lateinit var topRatedAdapter: HomeScreenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = HomeScreenPresenter(this)


        presenter.loadFilms()
        configureRecyclerViewUpcoming()
        configureRecyclerViewPopular()
        configureRecyclerViewNowPlaying()
        configureRecyclerViewTopRated()


    }

    private fun configureRecyclerViewTopRated() {
        topRatedAdapter = HomeScreenAdapter(clickOnTheMovie = { info ->
            val movieInfo = Intent(this, InfoScreenActivity::class.java)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_ID_MOVIE, info.id)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_NAME_MOVIE, info.title)
            movieInfo.putIntegerArrayListExtra(InfoScreenActivity.EXTRA_GENRES_MOVIE, info.genreIds)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_LANGUAGE_MOVIE, info.originalLanguage)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_AVERAGE_MOVIE, info.vote_average)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_DATE_MOVIE, info.release_date)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_OVERVIEW_MOVIE, info.overview)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_IMAGE_MOVIE, info.poster_path)
            startActivity(movieInfo)
        })
        binding.recyclerToprated.adapter = topRatedAdapter
    }

    private fun configureRecyclerViewNowPlaying() {
        nowPlayingAdapter = HomeScreenAdapter(clickOnTheMovie = { info ->
            val movieInfo = Intent(this, InfoScreenActivity::class.java)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_ID_MOVIE, info.id)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_NAME_MOVIE, info.title)
            movieInfo.putIntegerArrayListExtra(InfoScreenActivity.EXTRA_GENRES_MOVIE, info.genreIds)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_LANGUAGE_MOVIE, info.originalLanguage)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_AVERAGE_MOVIE, info.vote_average)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_DATE_MOVIE, info.release_date)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_OVERVIEW_MOVIE, info.overview)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_IMAGE_MOVIE, info.poster_path)
            startActivity(movieInfo)
        })
        binding.recyclerNowplaying.adapter = nowPlayingAdapter
    }

    private fun configureRecyclerViewPopular() {
        popularAdapter = HomeScreenAdapter(clickOnTheMovie = { info ->
            val movieInfo = Intent(this, InfoScreenActivity::class.java)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_ID_MOVIE, info.id)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_NAME_MOVIE, info.title)
            movieInfo.putIntegerArrayListExtra(InfoScreenActivity.EXTRA_GENRES_MOVIE, info.genreIds)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_LANGUAGE_MOVIE, info.originalLanguage)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_AVERAGE_MOVIE, info.vote_average)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_DATE_MOVIE, info.release_date)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_OVERVIEW_MOVIE, info.overview)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_IMAGE_MOVIE, info.poster_path)
            startActivity(movieInfo)
        })
        binding.recyclerPopularMovies.adapter = popularAdapter
    }

    private fun configureRecyclerViewUpcoming() {
        homeScreenAdapter = HomeScreenAdapter(clickOnTheMovie = { info ->
            val movieInfo = Intent(this, InfoScreenActivity::class.java)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_ID_MOVIE, info.id)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_NAME_MOVIE, info.title)
            movieInfo.putIntegerArrayListExtra(InfoScreenActivity.EXTRA_GENRES_MOVIE, info.genreIds)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_LANGUAGE_MOVIE, info.originalLanguage)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_AVERAGE_MOVIE, info.vote_average)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_DATE_MOVIE, info.release_date)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_OVERVIEW_MOVIE, info.overview)
            movieInfo.putExtra(InfoScreenActivity.EXTRA_IMAGE_MOVIE, info.poster_path)
            startActivity(movieInfo)
        })
        binding.recyclerUpcoming.adapter = homeScreenAdapter
    }

    fun showOnScreen(
        upcomingResult: List<MoviesResultsApiResponse>,
        popularResult: List<MoviesResultsApiResponse>,
        nowPlaying: List<MoviesResultsApiResponse>,
        topRated: List<MoviesResultsApiResponse>
    ) {
        homeScreenAdapter.update(upcomingResult)
        popularAdapter.update(popularResult)
        nowPlayingAdapter.update(nowPlaying)
        topRatedAdapter.update(topRated)
    }

    fun showLoading() {
        binding.loading.visibility = View.VISIBLE
        binding.titlePopularMovies.visibility = View.GONE
        binding.titleUpcoming.visibility = View.GONE
        binding.titleNowplaying.visibility = View.GONE
        binding.titleToprated.visibility = View.GONE
    }

    fun hideLoading() {
        binding.loading.visibility = View.GONE
        binding.titlePopularMovies.visibility = View.VISIBLE
        binding.titleUpcoming.visibility = View.VISIBLE
        binding.titleNowplaying.visibility = View.VISIBLE
        binding.titleToprated.visibility = View.VISIBLE
    }
}