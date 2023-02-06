package com.example.chattest.presentation.ui.message

import androidx.lifecycle.viewModelScope
import com.example.chattest.domain.model.FeedUiModel
import com.example.chattest.domain.model.MessageUiModel
import com.example.chattest.domain.model.StoryUiModel
import com.example.chattest.domain.use_case.MessageUseCase
import com.example.chattest.presentation.base.BaseViewModel
import com.example.chattest.presentation.ui.home.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    private val useCase: MessageUseCase
) : BaseViewModel() {


    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    init {
        getMessage()
    }


     private var tempList = emptyList<MessageUiModel>()

    private fun getMessage(){
        viewModelScope.launch {
            request(
                flow = useCase(),
                onSuccess = {
                    _uiState.update { uiState ->
                        uiState.copy(message = it)
                    }
                }

            )

        }
    }

    fun setTempList(list:List<MessageUiModel>){
        tempList = list
    }


    fun searchUser(query: String): List<MessageUiModel> {
        return search(query)
    }

    private fun search(query: String): List<MessageUiModel> {
        return tempList.filter { s -> s.senderName?.contains(query, true) ?: false }
    }

    data class UiState(
        val message: List<MessageUiModel> = emptyList()
    )

}