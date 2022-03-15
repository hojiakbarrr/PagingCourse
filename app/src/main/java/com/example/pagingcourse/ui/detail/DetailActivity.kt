package com.example.pagingcourse.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import coil.load
import com.example.pagingcourse.R
import com.example.pagingcourse.databinding.ActivityDetailBinding
import com.example.pagingcourse.models.singlecharacter.SingleCharacter
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi


@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val binding: ActivityDetailBinding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val id = intent.getIntExtra("id", 0)
        viewModel.detail(id)
        Log.d("testing", "id ${id}")

        viewModel.detail.observe(this) {
            showDetail(it)

        }

    }

    private fun showDetail(it: SingleCharacter?) {
        binding.apply {
            val imageLink = it!!.image

            image.load(imageLink){
                crossfade(true)
                crossfade(1000)
            }
            name.text = it!!.name
            id.text = it.id.toString()
            status.text = it.status
            gender.text = it.gender
            originName.text = it.origin.name
            locationName.text = it.location.name
            locationUrl.text = it.location.url
            episodes.text = it.episode.toString()
            originUrl.text = it.origin.url
            url.text = it.url
            created.text = it.created
        }
    }
}