package com.example.chattest.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.chattest.R
import com.example.chattest.common.extensions.loadCircularImage
import com.example.chattest.databinding.StoryAddItemBinding
import com.example.chattest.databinding.StoryViewItemBinding
import com.example.chattest.domain.model.StoryUiModel
import com.example.chattest.shared.utils.StoryClickEvent
import com.example.chattest.shared.utils.StoryViewType

class StoryAdapter(
    private val onItemClick: (StoryClickEvent, StoryUiModel) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var bindingAddStory: StoryAddItemBinding
    private lateinit var bindingStory: StoryViewItemBinding

    var storyList = emptyList<StoryUiModel>()

    fun addStory(story:List<StoryUiModel>){
        storyList = story
        notifyItemRangeChanged(0,story.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            StoryViewType.ADD_STORY.value -> {
                bindingAddStory = StoryAddItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                AddStoryViewHolder(bindingAddStory,onItemClick)
            }
            StoryViewType.VIEW_STORY.value -> {
                bindingStory = StoryViewItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ViewStoryViewHolder(bindingStory,onItemClick)
            }
            else -> {
                bindingStory = StoryViewItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ViewStoryViewHolder(bindingStory,onItemClick)
            }
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0){
            (holder as AddStoryViewHolder).bind(storyList[position] )
        }else{
            (holder as ViewStoryViewHolder).bind(storyList[position])
        }
    }

    override fun getItemCount(): Int = storyList.size

    override fun getItemViewType(position: Int): Int =
        if (position == 0 ){
            StoryViewType.ADD_STORY.value
        }else{
            StoryViewType.VIEW_STORY.value
        }

    class AddStoryViewHolder(
        private val binding: StoryAddItemBinding,
        private val onItemClick: (StoryClickEvent, StoryUiModel) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(storyUiModel: StoryUiModel) {

        }
    }

    class ViewStoryViewHolder(
        private val binding: StoryViewItemBinding,
        private val onItemClick: (StoryClickEvent, StoryUiModel) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(storyUiModel: StoryUiModel) {
            binding.ivStoryView.loadCircularImage(
                storyUiModel.imageUrl,
                4f,
                ContextCompat.getColor(binding.root.context, R.color.blue)
            )
            binding.root.setOnClickListener {
                onItemClick.invoke(StoryClickEvent.VIEW_STORY,storyUiModel)
            }
            binding.ivStoryView.setOnClickListener {
                onItemClick.invoke(StoryClickEvent.VIEW_STORY,storyUiModel)
            }
        }
    }
}