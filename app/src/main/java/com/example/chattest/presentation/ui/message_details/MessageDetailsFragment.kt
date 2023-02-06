package com.example.chattest.presentation.ui.message_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.chattest.R
import com.example.chattest.common.extensions.loadUrlCircle
import com.example.chattest.databinding.FragmentMessageDetailsBinding
import com.example.chattest.domain.model.MessageProfileUiModel
import com.example.chattest.presentation.base.BaseFragment
import com.example.chattest.presentation.ui.message.adapter.MessageAdapter
import com.example.chattest.presentation.ui.message_details.adapter.MessageDetailsAdapter
import com.example.chattest.shared.mock_data.MessageMock
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

private const val ARG_USER_MODEL = "user_model"

@AndroidEntryPoint
class MessageDetailsFragment : BaseFragment<FragmentMessageDetailsBinding>(FragmentMessageDetailsBinding::inflate) {

    private val viewModel:MessageDetailsViewModel by viewModels()

    private var userModel: MessageProfileUiModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userModel = it.getParcelable(ARG_USER_MODEL)
        }
    }

    private fun observe() = with(viewModel) {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    uiState.collectLatest { uiState ->
                        (binding.rvMessages.adapter as MessageDetailsAdapter).submitList(uiState.message)
                    }
                }

            }

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        initView()
        initMessageRecyclerView()
    }

    private fun initView(){
        userModel?.let { itModel->
            binding.ivProfilePhoto.loadUrlCircle(itModel.userImage)
            binding.tvName.text = itModel.name
        }
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initMessageRecyclerView(){
        val messageAdapter = MessageDetailsAdapter()
        binding.rvMessages.adapter = messageAdapter
    }

}