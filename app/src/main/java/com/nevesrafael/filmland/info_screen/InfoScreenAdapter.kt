package com.nevesrafael.filmland.info_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nevesrafael.filmland.databinding.ItemActorBinding
import com.nevesrafael.filmland.model.ActorsResultsApiResponse

class InfoScreenAdapter : RecyclerView.Adapter<InfoScreenViewHolder>() {

    private val results = mutableListOf<ActorsResultsApiResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoScreenViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemActorBinding.inflate(inflater, parent, false)
        return InfoScreenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InfoScreenViewHolder, position: Int) {
        val item = results[position]
        holder.bind(item)
    }

    override fun getItemCount() = results.size

    fun update(result: List<ActorsResultsApiResponse>) {
        this.results.clear()
        this.results.addAll(result)
        notifyDataSetChanged()
    }
}

class InfoScreenViewHolder(val binding: ItemActorBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(result: ActorsResultsApiResponse) {
        binding.actorName.text = result.name
        binding.character.text = result.character
        binding.imageActor.load("https://image.tmdb.org/t/p/w500/${result.photo}")
    }

}
