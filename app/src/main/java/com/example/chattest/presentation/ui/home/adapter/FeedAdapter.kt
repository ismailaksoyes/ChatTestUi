package com.example.chattest.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chattest.common.extensions.loadCircularImage
import com.example.chattest.common.extensions.loadUrl
import com.example.chattest.databinding.FeedViewItemBinding
import com.example.chattest.domain.model.FeedUiModel
import com.example.chattest.shared.utils.FeedClickEvent

class FeedAdapter(private val onItemClick: (FeedClickEvent, FeedUiModel) -> Unit) :
    ListAdapter<FeedUiModel, FeedViewHolder>(DiffCallbackFeed()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val binding =
            FeedViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

private class DiffCallbackFeed : DiffUtil.ItemCallback<FeedUiModel>() {
    override fun areItemsTheSame(
        oldItem: FeedUiModel,
        newItem: FeedUiModel
    ): Boolean {
        return oldItem.feedId == newItem.feedId
    }

    override fun areContentsTheSame(
        oldItem: FeedUiModel,
        newItem: FeedUiModel
    ): Boolean {
        return oldItem == newItem
    }
}

class FeedViewHolder(
    private val binding: FeedViewItemBinding,
    private val onItemClick: (FeedClickEvent, FeedUiModel) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: FeedUiModel?) {
        data?.let { fData ->
            fData.feedCreatedDate?.let { itCreatedData ->
                binding.tvTime.text = itCreatedData
            }
            fData.commentCount?.let { itCommentCount ->
                binding.tvCommentCount.text = itCommentCount
            }

            fData.feedImageUrl?.let { itFeedImageUrl ->
                binding.ivPoster.loadUrl(itFeedImageUrl)
            }

            fData.likeCount?.let { itLikeCount ->
                binding.tvLikeCount.text = itLikeCount

            }

            fData.likeStatus?.let { itLikeStatus ->
                binding.cbLike.isChecked = itLikeStatus
            }

            fData.profileImageUrl?.let { itProfileImageUrl ->
                binding.ivProfile.loadCircularImage(itProfileImageUrl)
            }

            fData.savedCount?.let { itSavedCount ->
                binding.tvSavedCount.text = itSavedCount

            }

            fData.userName?.let { itUserName ->

                binding.tvName.text = itUserName

            }
        }
    }
}