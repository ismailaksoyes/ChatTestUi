package com.example.chattest.domain.repository

import com.example.chattest.domain.model.*
import com.example.chattest.shared.utils.RestResult

interface Repository {
    suspend fun getHomeFeed():RestResult<List<FeedUiModel>>
    suspend fun getHomeStory():RestResult<List<StoryUiModel>>
    suspend fun getMessageDetails():RestResult<List<MessageDetailsUiModel>>
    suspend fun getMessage():RestResult<List<MessageUiModel>>
    suspend fun getProfileDetail():RestResult<ProfileUiModel>
    suspend fun getProfilePost():RestResult<List<PostUiModel>>
}