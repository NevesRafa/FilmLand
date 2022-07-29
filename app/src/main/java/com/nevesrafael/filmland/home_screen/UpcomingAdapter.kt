package com.nevesrafael.filmland.home_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nevesrafael.filmland.databinding.ItemPosterBinding
import com.nevesrafael.filmland.model.MoviesResultsApiResponse

class UpcomingAdapter(private val clickOnTheMovie: (MoviesResultsApiResponse) -> Unit) : RecyclerView.Adapter<UpcomingViewHolder>() {

    private val upcomingResults = mutableListOf<MoviesResultsApiResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPosterBinding.inflate(inflater, parent, false)
        return UpcomingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        val item = upcomingResults[position]
        holder.bind(item, clickOnTheMovie)
    }

    override fun getItemCount() = upcomingResults.size

    fun update(result: List<MoviesResultsApiResponse>) {
        this.upcomingResults.clear()
        this.upcomingResults.addAll(result)
        notifyDataSetChanged()
    }

}

class UpcomingViewHolder(val binding: ItemPosterBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(result: MoviesResultsApiResponse, clickOnTheMovie: (MoviesResultsApiResponse) -> Unit) {
        binding.average.text = result.vote_average.toString()
        binding.imagePoster.load("https://image.tmdb.org/t/p/w500/${result.poster_path}")

        binding.root.setOnClickListener {
            clickOnTheMovie(result)
        }
    }

}
