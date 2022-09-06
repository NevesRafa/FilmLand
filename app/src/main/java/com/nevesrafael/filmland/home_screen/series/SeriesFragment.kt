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
    private lateinit var adapter: MoviesAdapter

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

        presenter.loadSeries()

    }

    private fun configureRecyclerAiringToday() {
        adapter = MoviesAdapter(clickOnTheMovie = { info ->
            sendSerieToInfo(info.id)
        })
        binding.recyclerAiringToday.adapter = adapter
    }

    private fun sendSerieToInfo(id: Int) {
        val movieInfo = Intent(requireContext(), InfoScreenActivity::class.java)
        movieInfo.putExtra(InfoScreenActivity.EXTRA_ID_MOVIE, id)
        startActivity(movieInfo)
    }

    fun showOnScreen(airingTodayResults: List<HomeItemDataResults>) {
        adapter.update(airingTodayResults)
    }
}