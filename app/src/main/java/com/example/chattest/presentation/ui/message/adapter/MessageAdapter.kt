package com.example.chattest.presentation.ui.message.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chattest.common.extensions.loadCircularImage
import com.example.chattest.common.extensions.loadUrlCircle
import com.example.chattest.databinding.MessageViewItemBinding
import com.example.chattest.domain.model.MessageUiModel

class MessageAdapter(private val onItemClick: (user:MessageUiModel) -> Unit) :
    ListAdapter<MessageUiModel, FeedViewHolder>(DiffCallbackShareMealFood()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val binding =
            MessageViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}

private class DiffCallbackShareMealFood : DiffUtil.ItemCallback<MessageUiModel>() {
    override fun areItemsTheSame(
        oldItem: MessageUiModel,
        newItem: MessageUiModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: MessageUiModel,
        newItem: MessageUiModel
    ): Boolean {
        return oldItem == newItem
    }
}

class FeedViewHolder(
    private val binding: MessageViewItemBinding,
    private val onItemClick:  (user:MessageUiModel) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: MessageUiModel?) {
        data?.let { itData ->
            itData.senderName?.let { itSenderName ->
                binding.tvUser.text = itSenderName
            }
            itData.senderImageUrl?.let { itUrl->
                binding.ivProfilePhoto.loadUrlCircle(itUrl)
            }

            itData.lastMessage?.let { itLastMessage->
                binding.tvUserLastMessage.text = itLastMessage
            }

           binding.root.setOnClickListener {
               onItemClick.invoke(itData)
           }
        }
    }
}