package com.example.chattest.data.repository

import com.example.chattest.domain.model.*
import com.example.chattest.domain.repository.Repository
import com.example.chattest.shared.mock_data.FeedMock
import com.example.chattest.shared.mock_data.MessageMock
import com.example.chattest.shared.mock_data.ProfileMock
import com.example.chattest.shared.utils.RestResult
import javax.inject.Inject

class MockRepositoryImpl @Inject constructor():Repository {
    override suspend fun getHomeFeed(): RestResult<List<FeedUiModel>> {
       return RestResult.Success(FeedMock.getFeedData())
    }

    override suspend fun getHomeStory(): RestResult<List<StoryUiModel>> {
        return RestResult.Success(FeedMock.getStoryData())
    }

    override suspend fun getMessageDetails(): RestResult<List<MessageDetailsUiModel>> {
        return RestResult.Success(MessageMock.getMessageDetails())
    }

    override suspend fun getMessage(): RestResult<List<MessageUiModel>> {
        return RestResult.Success(MessageMock.getMessageList())
    }


    override suspend fun getProfileDetail(): RestResult<ProfileUiModel> {
        return RestResult.Success(ProfileMock.getProfileData())
    }

    override suspend fun getProfilePost(): RestResult<List<PostUiModel>> {
        return RestResult.Success(ProfileMock.getProfileData().postItem)
    }


}