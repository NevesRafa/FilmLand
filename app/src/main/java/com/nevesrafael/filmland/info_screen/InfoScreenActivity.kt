package com.nevesrafael.filmland.info_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment
import com.nevesrafael.filmland.R
import com.nevesrafael.filmland.databinding.ActivityInfoScreenBinding
import com.nevesrafael.filmland.formatter.DateFormatter
import com.nevesrafael.filmland.model.ActorsResultsApiResponse
import com.nevesrafael.filmland.model.MoviesApiResponseTest

class InfoScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoScreenBinding
    private lateinit var presenter: InfoScreenPresenter
    private lateinit var actorsAdapter: InfoScreenAdapter

    companion object {
        const val EXTRA_NAME_MOVIE = "extra.name.movie"
        const val EXTRA_GENRES_MOVIE = "extra.genres.movie"
        const val EXTRA_ID_MOVIE = "extra.id.movie"
        const val EXTRA_LANGUAGE_MOVIE = "extra.language.movie"
        const val EXTRA_AVERAGE_MOVIE = "extra.averange.movie"
        const val EXTRA_DATE_MOVIE = "extra.date.movie"
        const val EXTRA_OVERVIEW_MOVIE = "extra.overview.movie"
        const val EXTRA_IMAGE_MOVIE = "extra.image.movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = InfoScreenPresenter(this)
        configureRecyclerViewActors()
        // presenter.loadInfo()
        receiveAndSendId()

    }

    private fun receiveAndSendId() {
        val movieId = intent.getIntExtra(EXTRA_ID_MOVIE, 0)
        presenter.loadTrailers(movieId)
        presenter.loadActors(movieId)
        presenter.loadInfo(movieId)
    }

    private fun configureRecyclerViewActors() {
        actorsAdapter = InfoScreenAdapter()
        binding.recyclerCast.adapter = actorsAdapter
    }

    fun showOnScreen(info: MoviesApiResponseTest) {

        val name = info.title
        // val genres = info.genres
        val language = info.original_language
        val average = info.vote_average
        val date = info.release_date
        val overview = info.overview
        val year = date.let { DateFormatter.dateFormatter(it) }
//        val data = intent.extras
//        val name = data?.getString(EXTRA_NAME_MOVIE)
//        val genres = data?.getIntArray(EXTRA_GENRES_MOVIE)
//        val language = data?.getString(EXTRA_LANGUAGE_MOVIE)
//        val average = data?.getDouble(EXTRA_AVERAGE_MOVIE, 0.0)
//        val date = data?.getString(EXTRA_DATE_MOVIE)
//        val overview = data?.getString(EXTRA_OVERVIEW_MOVIE)
//        val image = data?.getString(EXTRA_IMAGE_MOVIE) ?: ""
//
//        val year = date?.let { DateFormatter.dateFormatter(it) }
//
        binding.language.text = "Original Language: $language"
        binding.fullReleaseDate.text = "Release Date: $date"
        binding.infoAverage.text = "%.1f".format(average)
        binding.sinopse.text = overview
        binding.movieName.text = "$name ($year)"
    }

    fun showTrailer(youtubeId: String) {

        val youtube = fragmentManager.findFragmentById(R.id.youtube_trailers) as YouTubePlayerFragment

        youtube.initialize(
            "AIzaSyDQTXkaqNiVJ3AB7FRZt5TarWqlWTUm8kQ",
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, player: YouTubePlayer?, b: Boolean) {
                    player?.cueVideo(youtubeId)
                }

                override fun onInitializationFailure(provider: YouTubePlayer.Provider?, result: YouTubeInitializationResult?) {
                    R.drawable.error
                }
            })
    }

    fun showActors(actorsResult: List<ActorsResultsApiResponse>) {
        actorsAdapter.update(actorsResult)
    }

}
