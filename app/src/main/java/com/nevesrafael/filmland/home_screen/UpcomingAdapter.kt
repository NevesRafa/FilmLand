package com.nevesrafael.filmland.home_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nevesrafael.filmland.databinding.ItemPosterBinding
import com.nevesrafael.filmland.model.UpcomingResultsApiResponse

class UpcomingAdapter : RecyclerView.Adapter<UpcomingViewHolder>() {

    private val UpcomingResults = mutableListOf<UpcomingResultsApiResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPosterBinding.inflate(inflater, parent, false)
        return UpcomingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}

class UpcomingViewHolder(val binding: ItemPosterBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(result: UpcomingResultsApiResponse) {
        binding.average.text = result.vote_average.toString()

    }

}
