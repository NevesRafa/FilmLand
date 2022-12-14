package com.nevesrafael.filmland.home_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.nevesrafael.filmland.R
import com.nevesrafael.filmland.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureTabs()
        scrollLock()
    }

    private fun configureTabs() {
        val tabsAdapter = HomeScreenTabAdapter(this)
        binding.viewPager.adapter = tabsAdapter

        val mediator = TabLayoutMediator(binding.tablayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.setText(R.string.films)
                    tab.setIcon(R.drawable.ic_movie)
                }
                1 -> {
                    tab.setText(R.string.series)
                    tab.setIcon(R.drawable.ic_television)
                }
                2 -> {
                    tab.setText(R.string.my_list)
                    tab.setIcon(R.drawable.ic_heart)
                }
            }
        }
        mediator.attach()
    }

    private fun scrollLock() {
        binding.viewPager.isUserInputEnabled = false
    }
}