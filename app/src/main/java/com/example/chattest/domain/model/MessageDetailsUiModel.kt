package com.example.chattest.domain.model

import com.example.chattest.shared.utils.MessageType

data class MessageDetailsUiModel(
    val id:Int,
    val type:MessageType,
    val messageBody:String
)
