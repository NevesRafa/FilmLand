package com.nevesrafael.filmland.info_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nevesrafael.filmland.databinding.ActivityInfoScreenBinding
import com.nevesrafael.filmland.formatter.DateFormatter

class InfoScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoScreenBinding
    private lateinit var presenter: InfoScreenPresenter

    companion object {
        const val EXTRA_NAME_MOVIE = "extra.name.movie"
        const val EXTRA_GENRES_MOVIE = "extra.genres.movie"
        const val EXTRA_ID_MOVIE = "extra.id.movie"
        const val EXTRA_LANGUAGE_MOVIE = "extra.language.movie"
        const val EXTRA_AVERAGE_MOVIE = "extra.averange.movie"
        const val EXTRA_DATE_MOVIE = "extra.date.movie"
        const val EXTRA_OVERVIEW_MOVIE = "extra.overview.movie"
        const val REQUEST_CODE = 123
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = InfoScreenPresenter(this)
        showOnScreen()

    }


    private fun showOnScreen() {

        val data = intent.extras
        val id = data?.getInt(EXTRA_ID_MOVIE, 0) ?: 0
        val name = data?.getString(EXTRA_NAME_MOVIE)
        val genres = data?.getIntArray(EXTRA_GENRES_MOVIE)
        val language = data?.getString(EXTRA_LANGUAGE_MOVIE)
        val average = data?.getDouble(EXTRA_AVERAGE_MOVIE, 0.0)
        val date = data?.getString(EXTRA_DATE_MOVIE)
        val overview = data?.getString(EXTRA_OVERVIEW_MOVIE)

        val year = date?.let { DateFormatter.dateFormatter(it) }

        binding.language.text = "Original Language: $language"
        binding.fullReleaseDate.text = "Release Date: $date"
        binding.infoAverage.text = average.toString()
        binding.sinopse.text = overview
        binding.movieName.text = "$name ($year)"


    }


}