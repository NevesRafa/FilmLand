package com.nevesrafael.filmland.home_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nevesrafael.filmland.databinding.ActivityHomeScreenBinding
import com.nevesrafael.filmland.model.UpcomingResultsApiResponse

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var presenter: HomeScreenPresenter
    private lateinit var upcomingAdapter: UpcomingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = HomeScreenPresenter(this)

        presenter.loadFilms()
        configureRecyclerViewUpcoming()
    }

    private fun configureRecyclerViewUpcoming() {
        upcomingAdapter = UpcomingAdapter()
        binding.recyclerUpcoming.adapter = upcomingAdapter
    }

    fun showOnScreen(upcomingResult: List<UpcomingResultsApiResponse>) {

        upcomingAdapter.update(upcomingResult)


    }
}