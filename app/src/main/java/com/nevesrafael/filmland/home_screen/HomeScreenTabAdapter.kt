package com.nevesrafael.filmland.home_screen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nevesrafael.filmland.home_screen.movies.MoviesFragment
import com.nevesrafael.filmland.home_screen.series.SeriesFragment

class HomeScreenTabAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        val fragment = when (position) {
            0 -> MoviesFragment()
            1 -> SeriesFragment()
            // 2 -> MyListFragment()
            else -> Fragment() // nunca vai acontecer!
        }

        return fragment
    }

    override fun getItemCount() = 3
}