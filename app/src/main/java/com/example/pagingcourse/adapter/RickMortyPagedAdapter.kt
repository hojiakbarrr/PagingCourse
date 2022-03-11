package com.example.pagingcourse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pagingcourse.adapter.RickMortyPagedAdapter.*
import com.example.pagingcourse.databinding.CharacterLayoutBinding
import com.example.pagingcourse.models.RickMorty

class RickMortyPagedAdapter : PagingDataAdapter<RickMorty, MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding: CharacterLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<RickMorty>() {
            override fun areItemsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            tvDescription.text = currentItem!!.name
            val imageLink = currentItem.image

            imageView.load(imageLink){
                crossfade(true)
                crossfade(1000)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(CharacterLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false
            )
        )
    }
}