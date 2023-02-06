package com.example.chattest.presentation.ui.home

import androidx.lifecycle.viewModelScope
import com.example.chattest.domain.model.FeedUiModel
import com.example.chattest.domain.model.StoryUiModel
import com.example.chattest.domain.use_case.HomeFeedUseCase
import com.example.chattest.domain.use_case.HomeStoryUseCase
import com.example.chattest.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeFeedUseCase: HomeFeedUseCase,
    private val homeStoryUseCase: HomeStoryUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    init {
        getHomeFeed()
        getHomeStory()
    }



    private fun getHomeFeed(){
        viewModelScope.launch {
            request(
                flow = homeFeedUseCase(),
                onSuccess = {
                    _uiState.update { uiState ->
                        uiState.copy(feed = it)
                    }
                }
            )
        }
    }

    private fun getHomeStory(){
        viewModelScope.launch {
            request(
                flow = homeStoryUseCase(),
                onSuccess = {
                    _uiState.update { uiState ->
                        uiState.copy(story = it)
                    }
                }
            )
        }
    }

    data class UiState(
        val feed: List<FeedUiModel> = emptyList(),
        val story: List<StoryUiModel> = emptyList()
    )

}