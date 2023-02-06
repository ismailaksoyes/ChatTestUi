package com.example.chattest.presentation.ui.message_details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chattest.databinding.*
import com.example.chattest.domain.model.MessageDetailsUiModel
import com.example.chattest.shared.utils.MessageType

class MessageDetailsAdapter() :
    ListAdapter<MessageDetailsUiModel, RecyclerView.ViewHolder>(DiffCallbackMessageDetails()) {

    private lateinit var bindingReceiver: MessageReceiveItemBinding
    private lateinit var bindingSender: MessageSenderItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when(viewType){
            MessageType.RECEIVE.value->{
               bindingReceiver =   MessageReceiveItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ReceiverViewHolder(bindingReceiver)
            }
            MessageType.SEND.value->{
               bindingSender=  MessageSenderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SenderViewHolder(bindingSender)
            }
            else ->{
                bindingSender=  MessageSenderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SenderViewHolder(bindingSender)
            }
        }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       if (getItem(position).type == MessageType.SEND){
           (holder as SenderViewHolder).bind(getItem(position))
       }else{
           (holder as ReceiverViewHolder).bind(getItem(position))
       }
    }

    override fun getItemViewType(position: Int): Int {
      return  if (getItem(position).type == MessageType.SEND){
           MessageType.SEND.value
        }else{
           MessageType.RECEIVE.value
        }

    }


}

private class DiffCallbackMessageDetails : DiffUtil.ItemCallback<MessageDetailsUiModel>() {
    override fun areItemsTheSame(
        oldItem: MessageDetailsUiModel,
        newItem: MessageDetailsUiModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: MessageDetailsUiModel,
        newItem: MessageDetailsUiModel
    ): Boolean {
        return oldItem == newItem
    }
}

class SenderViewHolder(
    private val binding: MessageSenderItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: MessageDetailsUiModel?) {
        data?.let { itData ->
            binding.tvMessageText.text = itData.messageBody
        }
    }
}

class ReceiverViewHolder(
    private val binding: MessageReceiveItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: MessageDetailsUiModel?) {
        data?.let { itData ->
            binding.tvMessageText.text = itData.messageBody
        }
    }
}