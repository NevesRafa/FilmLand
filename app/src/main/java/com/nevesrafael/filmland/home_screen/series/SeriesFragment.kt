package com.nevesrafael.filmland.home_screen.series

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nevesrafael.filmland.databinding.FragmentSeriesBinding
import com.nevesrafael.filmland.home_screen.movies.MoviesAdapter
import com.nevesrafael.filmland.info_screen.InfoScreenActivity
import com.nevesrafael.filmland.model.HomeItemDataResults

class SeriesFragment : Fragment() {

    private lateinit var binding: FragmentSeriesBinding
    private lateinit var presenter: SeriesPresenter
    private lateinit var airingTodayAdapter: MoviesAdapter
    private lateinit var popularAdapter: MoviesAdapter
    private lateinit var topRatedAdapter: MoviesAdapter
    private lateinit var onTheAirAdapter: MoviesAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSeriesBinding.inflate(layoutInflater, container, false)
        presenter = SeriesPresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecyclerAiringToday()
        configurePopular()
        configureOnTheAir()
        configureTopRated()

        presenter.loadSeries()

    }

    private fun configureRecyclerAiringToday() {
        airingTodayAdapter = MoviesAdapter(clickOnTheMovie = { info ->
            sendSerieToInfo(info.id)
        })
        binding.recyclerAiringToday.adapter = airingTodayAdapter
    }

    private fun configurePopular() {
        popularAdapter = MoviesAdapter(clickOnTheMovie = { info ->
            sendSerieToInfo(info.id)
        })
        binding.recyclerPopularSeries.adapter = popularAdapter
    }

    private fun configureTopRated() {
        topRatedAdapter = MoviesAdapter(clickOnTheMovie = { info ->
            sendSerieToInfo(info.id)
        })
        binding.recyclerTopRated.adapter = topRatedAdapter
    }

    private fun configureOnTheAir() {
        onTheAirAdapter = MoviesAdapter(clickOnTheMovie = { info ->
            sendSerieToInfo(info.id)
        })
        binding.recyclerOnTheAir.adapter = onTheAirAdapter
    }

    private fun sendSerieToInfo(id: Int) {
        val movieInfo = Intent(requireContext(), InfoScreenActivity::class.java)
        movieInfo.putExtra(InfoScreenActivity.EXTRA_ID_MOVIE, id)
        startActivity(movieInfo)
    }

    fun showOnScreen(
        airingTodayResults: List<HomeItemDataResults>,
        popularResult: List<HomeItemDataResults>,
        topRatedResult: List<HomeItemDataResults>,
        onTheAirResult: List<HomeItemDataResults>
    ) {
        airingTodayAdapter.update(airingTodayResults)
        popularAdapter.update(popularResult)
        topRatedAdapter.update(topRatedResult)
        onTheAirAdapter.update(onTheAirResult)
    }

    fun showLoading() {
        binding.loading.visibility = View.VISIBLE
        binding.titlePopularSeries.visibility = View.GONE
        binding.titleAiringToday.visibility = View.GONE
        binding.titleOnTheAir.visibility = View.GONE
        binding.titleTopRated.visibility = View.GONE
    }

    fun hideLoading() {
        binding.loading.visibility = View.GONE
        binding.titlePopularSeries.visibility = View.VISIBLE
        binding.titleAiringToday.visibility = View.VISIBLE
        binding.titleOnTheAir.visibility = View.VISIBLE
        binding.titleTopRated.visibility = View.VISIBLE
    }
}