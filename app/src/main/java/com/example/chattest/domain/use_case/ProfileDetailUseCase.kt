package com.example.chattest.domain.use_case

import com.example.chattest.domain.model.ProfileUiModel
import com.example.chattest.domain.repository.Repository
import com.example.chattest.shared.utils.NoInputUseCaseWithFlow
import com.example.chattest.shared.utils.RestResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfileDetailUseCase @Inject constructor(
    private val repository: Repository
) : NoInputUseCaseWithFlow<RestResult<ProfileUiModel>> {

    override suspend fun invoke(): Flow<RestResult<ProfileUiModel>> =
        flow {
            emit(repository.getProfileDetail())
        }

}