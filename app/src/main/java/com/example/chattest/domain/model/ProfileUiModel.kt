package com.example.chattest.domain.model

data class ProfileUiModel(
    val userName:String = "",
    val imageUrl:String = "",
    val name:String = "",
    val postCount:String = "",
    val followersCount:String = "",
    val followsCount:String = "",
    val postItem:List<PostUiModel> = emptyList()
)

