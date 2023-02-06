package com.example.chattest.presentation.ui.message_details

import androidx.lifecycle.viewModelScope
import com.example.chattest.domain.model.MessageDetailsUiModel
import com.example.chattest.domain.use_case.MessageDetailsUseCase
import com.example.chattest.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MessageDetailsViewModel @Inject constructor(
    private val useCase: MessageDetailsUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    init {
        getMessageDetails()
    }


    private fun getMessageDetails(){
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


    data class UiState(
        val message: List<MessageDetailsUiModel> = emptyList()
    )


}