package com.example.chattest.presentation.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.chattest.common.extensions.loadCircularImage
import com.example.chattest.databinding.FragmentProfileBinding
import com.example.chattest.domain.model.ProfileUiModel
import com.example.chattest.presentation.base.BaseFragment
import com.example.chattest.presentation.ui.message_details.adapter.MessageDetailsAdapter
import com.example.chattest.presentation.ui.profile.adapter.ProfilePostAdapter
import com.example.chattest.shared.mock_data.ProfileMock
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val viewModel:ProfileViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        initPostsRecyclerView()
    }

    private fun observe() = with(viewModel) {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    uiState.collectLatest { uiState ->
                        (binding.rvPhotos.adapter as ProfilePostAdapter).submitList(uiState.post)
                        initProfileDetails(uiState.postDetails)

                    }
                }

            }

        }
    }

    private fun initPostsRecyclerView(){
        val postsAdapter = ProfilePostAdapter()
        binding.rvPhotos.adapter = postsAdapter
       val mLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.rvPhotos.setHasFixedSize(true)
        binding.rvPhotos.layoutManager = mLayoutManager

    }

    private fun initProfileDetails(profileData:ProfileUiModel){
        binding.ivProfilePhoto.loadCircularImage(profileData.imageUrl)
        binding.tvName.text = profileData.name
        binding.tvUsername.text = "@${profileData.userName}"
        binding.tvProfilePosts.text = profileData.postCount
        binding.tvProfileFollowers.text = profileData.followersCount
        binding.tvProfileFollows.text = profileData.followsCount
    }

}