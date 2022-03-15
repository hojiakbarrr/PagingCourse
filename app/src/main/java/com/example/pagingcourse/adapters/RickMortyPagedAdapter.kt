package com.example.pagingcourse.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pagingcourse.adapters.RickMortyPagedAdapter.*
import com.example.pagingcourse.databinding.CharacterLayoutBinding
import com.example.pagingcourse.models.allCharacters.RickMorty

class RickMortyPagedAdapter (val mItemclickListener: ItemClickListener): PagingDataAdapter<RickMorty, MyViewHolder>(diffCallback) {

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
        holder.itemView.setOnClickListener{
            currentItem?.let { it1 -> mItemclickListener.onItemClick(it1.id) }
        }

//        Get a single character
//
//                + Get a single location
//
//                Filter characters  name: filter by the given name.
//
//        Get all locations + character
//
//        Get all episodes
//
//        Get a single episode


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(CharacterLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false
            )
        )
    }
}

interface ItemClickListener {
    fun onItemClick(id: Int)
}
