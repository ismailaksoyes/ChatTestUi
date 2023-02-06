package com.example.chattest.shared.mock_data

import com.example.chattest.domain.model.PostUiModel
import com.example.chattest.domain.model.ProfileUiModel

object ProfileMock {

    fun getProfileData(): ProfileUiModel {

        val postList = arrayListOf<PostUiModel>()
        postList.add(PostUiModel(0, "https://i.pinimg.com/originals/60/5d/81/605d81b6de3b6c17b4f3041576e42b5b.jpg"))
        postList.add(PostUiModel(1, "https://i.pinimg.com/736x/8a/b8/7b/8ab87bd6999d659eb282fbed00895d86--last-fm-album-cover.jpg"))
        postList.add(PostUiModel(2, "https://i.pinimg.com/236x/36/fa/84/36fa848ca5f0635fb7fd8f8519e518bd.jpg"))
        postList.add(PostUiModel(3, "https://i.pinimg.com/736x/46/2d/9e/462d9e85604868d7802d6236f969a72d.jpg"))
        postList.add(PostUiModel(4, "https://i.pinimg.com/736x/e2/68/db/e268db4df111a9641a8073915049f8bb.jpg"))
        postList.add(PostUiModel(5, "https://i.pinimg.com/736x/c3/70/bf/c370bfc32ad7d1a1964667f299ecc574.jpg"))
        postList.add(PostUiModel(6, "https://i.pinimg.com/736x/46/2d/9e/462d9e85604868d7802d6236f969a72d.jpg"))
        postList.add(PostUiModel(7, "https://i.pinimg.com/736x/46/2d/9e/462d9e85604868d7802d6236f969a72d.jpg"))

        return ProfileUiModel(
            userName = "testusername",
            imageUrl = "https://i.pinimg.com/736x/2e/d3/b8/2ed3b87f2e91cb1c9b25f40d4a2788e1.jpg",
            name = "TestName",
            postCount = "24",
            followersCount = "17",
            followsCount = "12",
            postItem = postList
        )
    }
}