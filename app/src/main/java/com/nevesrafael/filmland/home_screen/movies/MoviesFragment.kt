package com.nevesrafael.filmland.home_screen.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nevesrafael.filmland.databinding.FragmentMoviesBinding
import com.nevesrafael.filmland.info_screen.InfoScreenActivity
import com.nevesrafael.filmland.model.MoviesResultsApiResponse

class MoviesFragment : Fragment() {

    lateinit var binding: FragmentMoviesBinding
    lateinit var presenter: MoviesPresenter

    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var popularAdapter: MoviesAdapter
    private lateinit var nowPlayingAdapter: MoviesAdapter
    private lateinit var topRatedAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        presenter = MoviesPresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecyclerViewUpcoming()
        configureRecyclerViewPopular()
        configureRecyclerViewNowPlaying()
        configureRecyclerViewTopRated()

        presenter.loadMovies()
    }

    private fun configureRecyclerViewTopRated() {
        topRatedAdapter = MoviesAdapter(clickOnTheMovie = { info ->
            val movieInfo = Intent(requireContext(), InfoScreenActivity::class.java)
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
        nowPlayingAdapter = MoviesAdapter(clickOnTheMovie = { info ->
            val movieInfo = Intent(requireContext(), InfoScreenActivity::class.java)
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
        popularAdapter = MoviesAdapter(clickOnTheMovie = { info ->
            val movieInfo = Intent(requireContext(), InfoScreenActivity::class.java)
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
        moviesAdapter = MoviesAdapter(clickOnTheMovie = { info ->
            val movieInfo = Intent(requireContext(), InfoScreenActivity::class.java)
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
        binding.recyclerUpcoming.adapter = moviesAdapter
    }

    fun showOnScreen(
        upcomingResult: List<MoviesResultsApiResponse>,
        popularResult: List<MoviesResultsApiResponse>,
        nowPlaying: List<MoviesResultsApiResponse>,
        topRated: List<MoviesResultsApiResponse>
    ) {
        moviesAdapter.update(upcomingResult)
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