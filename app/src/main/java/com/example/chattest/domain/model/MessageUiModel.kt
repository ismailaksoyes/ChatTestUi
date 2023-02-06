package com.example.chattest.domain.model

data class MessageUiModel(
    val id:Int,
    val senderImageUrl:String?,
    val lastMessage:String?,
    val senderName:String?
)
