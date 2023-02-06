package com.example.chattest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MessageProfileUiModel(
    val userId:Int,
    val name:String,
    val userImage:String
):Parcelable
