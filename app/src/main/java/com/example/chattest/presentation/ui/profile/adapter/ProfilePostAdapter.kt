package com.example.chattest.presentation.ui.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chattest.common.extensions.loadUrl
import com.example.chattest.databinding.ProfilePostItemBinding
import com.example.chattest.domain.model.PostUiModel

class ProfilePostAdapter : ListAdapter<PostUiModel, MainViewHolder>(DiffCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ProfilePostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }




}
private class DiffCallback : DiffUtil.ItemCallback<PostUiModel>() {
    override fun areItemsTheSame(oldItem: PostUiModel, newItem: PostUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PostUiModel, newItem: PostUiModel): Boolean {
        return oldItem == newItem
    }

}

class MainViewHolder(val binding:ProfilePostItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(data:PostUiModel){
        binding.ivPost.loadUrl(data.imageUrl)
         val set = ConstraintSet()
        set.clone(binding.parentContsraint)
        val heightRatio = if( position % 2 == 0 ){
            1
        }else{
            2
        }
        val ratio =String.format("%d:%d", 1,heightRatio )
        set.setDimensionRatio(binding.ivPost.id, ratio)
        set.applyTo(binding.parentContsraint)
    }
}