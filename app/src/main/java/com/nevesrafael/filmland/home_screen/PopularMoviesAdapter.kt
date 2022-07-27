package com.nevesrafael.filmland.home_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nevesrafael.filmland.databinding.ItemPosterBinding
import com.nevesrafael.filmland.model.MoviesResultsApiResponse


class PopularMoviesAdapter : RecyclerView.Adapter<PopularMoviesViewHolder>() {

    private val popularResult = mutableListOf<MoviesResultsApiResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPosterBinding.inflate(inflater, parent, false)
        return PopularMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        val item = popularResult[position]
        holder.bind(item)
    }

    override fun getItemCount() = popularResult.size

    fun update(result: List<MoviesResultsApiResponse>) {
        this.popularResult.clear()
        this.popularResult.addAll(result)
        notifyDataSetChanged()
    }

}

class PopularMoviesViewHolder(val binding: ItemPosterBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(result: MoviesResultsApiResponse) {
        binding.average.text = result.vote_average.toString()
        binding.imagePoster.load("https://image.tmdb.org/t/p/w500/${result.poster_path}")
    }

}
