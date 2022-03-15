package com.example.pagingcourse.ui.main

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pagingcourse.adapters.ItemClickListener
import com.example.pagingcourse.adapters.RickMortyPagedAdapter
import com.example.pagingcourse.databinding.AllCharactersBlankFragmentBinding
import com.example.pagingcourse.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class AllCharactersBlankFragment : Fragment(), ItemClickListener {

    companion object {
        fun newInstance() = AllCharactersBlankFragment()
    }

    private lateinit var binding: AllCharactersBlankFragmentBinding
    private lateinit var mAdapter: RickMortyPagedAdapter
    private lateinit var viewModel: AllCharactersBlankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = AllCharactersBlankFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AllCharactersBlankViewModel::class.java)
        // TODO: Use the ViewModel
        setupRv()
        loadingData()

    }


    private fun loadingData() {
        lifecycleScope.launch {
            viewModel.listData.collect {pagingData ->
                mAdapter.submitData(pagingData)
            }
        }
    }


    private fun setupRv() {

        mAdapter = RickMortyPagedAdapter(this)
        binding.recyclerView.apply {

            layoutManager = StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)

            adapter= mAdapter
            setHasFixedSize(true)
        }
    }

    override fun onItemClick(id: Int) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

}