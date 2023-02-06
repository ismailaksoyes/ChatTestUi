package com.example.chattest.domain.model

data class FeedUiModel(
    val feedId : Int,
    val profileImageUrl:String?,
    val userName:String?,
    val feedImageUrl:String?,
    val feedCreatedDate:String?,
    val likeStatus:Boolean?,
    val likeCount:String?,
    val commentCount:String?,
    val savedCount:String?
)
