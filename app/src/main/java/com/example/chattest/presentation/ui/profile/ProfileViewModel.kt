package com.example.chattest.presentation.ui.profile

import androidx.lifecycle.viewModelScope
import com.example.chattest.domain.model.PostUiModel
import com.example.chattest.domain.model.ProfileUiModel
import com.example.chattest.domain.use_case.ProfileDetailUseCase
import com.example.chattest.domain.use_case.ProfilePostUseCase
import com.example.chattest.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profilePostUseCase: ProfilePostUseCase,
    private val profileDetailUseCase: ProfileDetailUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    init {
        getPost()
        getProfileDetails()
    }

    private fun getPost(){
        viewModelScope.launch {
            request(
                flow = profilePostUseCase(),
                onSuccess = {
                    _uiState.update { uiState ->
                        uiState.copy(post = it)
                    }
                }
            )
        }
    }

    private fun getProfileDetails(){
        viewModelScope.launch {
            request(
                flow = profileDetailUseCase(),
                onSuccess = {
                    _uiState.update { uiState ->
                        uiState.copy(postDetails = it)
                    }
                }
            )
        }
    }


    data class UiState(
        val post: List<PostUiModel> = emptyList(),
        val postDetails: ProfileUiModel = ProfileUiModel()
    )
}