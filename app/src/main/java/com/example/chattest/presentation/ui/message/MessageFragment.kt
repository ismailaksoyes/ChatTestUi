package com.example.chattest.presentation.ui.message


import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.chattest.databinding.FragmentMessageBinding
import com.example.chattest.domain.model.MessageProfileUiModel
import com.example.chattest.presentation.base.BaseFragment
import com.example.chattest.presentation.ui.home.adapter.FeedAdapter
import com.example.chattest.presentation.ui.home.adapter.StoryAdapter
import com.example.chattest.presentation.ui.message.adapter.MessageAdapter
import com.example.chattest.shared.mock_data.MessageMock
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MessageFragment : BaseFragment<FragmentMessageBinding>(FragmentMessageBinding::inflate) {

    private val viewModel: MessageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        initMessageRecyclerView()
        searchListener()
    }

    private fun searchListener() {
        binding.svMessage.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val list = viewModel.searchUser(newText ?: "")
                (binding.rvMessages.adapter as MessageAdapter).submitList(list)
                return false
            }
        })
    }

    private fun observe() = with(viewModel) {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    uiState.collectLatest { uiState ->
                        viewModel.setTempList(uiState.message)
                        (binding.rvMessages.adapter as MessageAdapter).submitList(uiState.message)
                    }
                }

            }

        }
    }




    private fun initMessageRecyclerView(){
        val messageAdapter = MessageAdapter{ user ->
            val action = MessageFragmentDirections.actionNavigationMessageToMessageDetailsFragment(
                MessageProfileUiModel(user.id,user.senderName?:"",user.senderImageUrl?:"")
            )
            findNavController().navigate(action)
        }
        binding.rvMessages.adapter = messageAdapter

    }

}