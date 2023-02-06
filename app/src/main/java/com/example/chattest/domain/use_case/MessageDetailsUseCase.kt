package com.example.chattest.domain.use_case

import com.example.chattest.domain.model.MessageDetailsUiModel
import com.example.chattest.domain.repository.Repository
import com.example.chattest.shared.utils.NoInputUseCaseWithFlow
import com.example.chattest.shared.utils.RestResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MessageDetailsUseCase @Inject constructor(
    private val repository: Repository
) : NoInputUseCaseWithFlow<RestResult<List<MessageDetailsUiModel>>> {

    override suspend fun invoke(): Flow<RestResult<List<MessageDetailsUiModel>>> =
        flow {
            emit(repository.getMessageDetails())
        }

}