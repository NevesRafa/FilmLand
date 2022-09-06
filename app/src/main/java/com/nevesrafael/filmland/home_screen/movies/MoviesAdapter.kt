package com.nevesrafael.filmland.home_screen.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nevesrafael.filmland.databinding.ItemPosterBinding
import com.nevesrafael.filmland.model.HomeItemDataResults

class MoviesAdapter(private val clickOnTheMovie: (HomeItemDataResults) -> Unit) :
    RecyclerView.Adapter<MoviesViewHolder>() {

    private val results = mutableListOf<HomeItemDataResults>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPosterBinding.inflate(inflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = results[position]
        holder.bind(item, clickOnTheMovie)
    }

    override fun getItemCount() = results.size

    fun update(result: List<HomeItemDataResults>) {
        this.results.clear()
        this.results.addAll(result)
        notifyDataSetChanged()
    }

}

class MoviesViewHolder(val binding: ItemPosterBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(result: HomeItemDataResults, clickOnTheMovie: (HomeItemDataResults) -> Unit) {
        binding.average.text = "%.1f".format(result.vote_average)
        binding.imagePoster.load("https://image.tmdb.org/t/p/w500/${result.poster_path}")

        binding.root.setOnClickListener {
            clickOnTheMovie(result)
        }
    }

}
