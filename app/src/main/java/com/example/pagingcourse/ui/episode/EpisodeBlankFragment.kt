package com.example.pagingcourse.ui.episode

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pagingcourse.R

class EpisodeBlankFragment : Fragment() {

    companion object {
        fun newInstance() = EpisodeBlankFragment()
    }

    private lateinit var viewModel: EpisodeBlankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.episode_blank_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EpisodeBlankViewModel::class.java)
        // TODO: Use the ViewModel
    }

}