package com.example.chattest.domain.use_case

import com.example.chattest.domain.model.PostUiModel
import com.example.chattest.domain.repository.Repository
import com.example.chattest.shared.utils.NoInputUseCaseWithFlow
import com.example.chattest.shared.utils.RestResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfilePostUseCase @Inject constructor(
    private val repository: Repository
) : NoInputUseCaseWithFlow<RestResult<List<PostUiModel>>> {

    override suspend fun invoke(): Flow<RestResult<List<PostUiModel>>> =
        flow {
            emit(repository.getProfilePost())
        }

}