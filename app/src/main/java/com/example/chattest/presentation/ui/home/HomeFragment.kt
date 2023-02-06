package com.example.chattest.presentation.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.chattest.databinding.FragmentHomeBinding
import com.example.chattest.presentation.base.BaseFragment
import com.example.chattest.presentation.ui.home.adapter.FeedAdapter
import com.example.chattest.presentation.ui.home.adapter.StoryAdapter
import com.example.chattest.shared.utils.StoryClickEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        initStoryRecyclerView()
        initFeedRecyclerView()
    }

    private fun observe() = with(viewModel) {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    uiState.collectLatest { uiState ->
                        (binding.rcFeedView.adapter as FeedAdapter).submitList(uiState.feed)
                        (binding.rcStoryView.adapter as StoryAdapter).addStory(uiState.story)
                    }
                }

            }

        }
    }

    private fun initStoryRecyclerView() {
        val storyAdapter = StoryAdapter { event, data ->
            when (event) {
                StoryClickEvent.VIEW_STORY -> {
                    setStoryViews(data.storyUrlList)
                }
                else -> {}
            }
        }
        binding.rcStoryView.adapter = storyAdapter
    }

    private fun initFeedRecyclerView() {
        val feedAdapter = FeedAdapter() { feedClickEvent, feedUiModel ->

        }
        binding.rcFeedView.adapter = feedAdapter
    }

    private fun setStoryViews(urlList: List<String>) {
        if (urlList.isNotEmpty()) {
            val action =
                HomeFragmentDirections.actionHomeFragmentToStoryFragment(urlList.toTypedArray())
            findNavController().navigate(action)
        }
    }

}