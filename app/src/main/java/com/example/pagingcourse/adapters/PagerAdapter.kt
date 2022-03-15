package com.example.pagingcourse.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pagingcourse.ui.episode.EpisodeBlankFragment
import com.example.pagingcourse.ui.location.LocationFragment
import com.example.pagingcourse.ui.main.AllCharactersBlankFragment

class PagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllCharactersBlankFragment()
            1 -> LocationFragment()
            2 -> EpisodeBlankFragment()
            else -> Fragment()
        }
    }
}