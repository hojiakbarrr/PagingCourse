package com.example.pagingcourse

import android.annotation.SuppressLint
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pagingcourse.adapters.PagerAdapter
import com.example.pagingcourse.adapters.RickMortyPagedAdapter
import com.example.pagingcourse.databinding.ActivityMainBinding
import com.example.pagingcourse.ui.RickMortyViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: RickMortyPagedAdapter
    private val viewModel: RickMortyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initial()

    }

    @SuppressLint("ResourceAsColor")
    private fun initial() {
        binding.viewPager.adapter = PagerAdapter(supportFragmentManager, lifecycle)
        binding.tabLayout.tabIconTint = null

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.ic_person)
                    tab.text = "Characters "
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.red))

                }
                1 -> {
                    tab.setIcon(R.drawable.ic_location)
                    tab.text = "Location"
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.blue))
                    tab.icon!!.alpha = 70
                }
                2 -> {
                    tab.setIcon(R.drawable.ic_video)
                    tab.text = "Episodes"
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.teal_700))
                    tab.icon!!.alpha = 70
                }
            }
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab!!.icon!!.alpha = 250
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab!!.icon!!.alpha = 70
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                tab?.icon!!.alpha = 250

            }

        })


    }

}
