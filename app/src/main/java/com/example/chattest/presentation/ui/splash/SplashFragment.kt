package com.example.chattest.presentation.ui.splash

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.os.bundleOf
import com.example.chattest.R
import com.example.chattest.databinding.FragmentSplashBinding
import com.example.chattest.domain.model.SplashUiModel
import com.example.chattest.presentation.base.BaseFragment


class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    companion object {
        private const val ARG_POSITION = "ARG_POSITION"

        fun getInstance(position: Int) = SplashFragment().apply {
            arguments = bundleOf(ARG_POSITION to position)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createSlider()
    }

    private fun createSlider(){
        arguments?.getInt(ARG_POSITION)?.let { itPosition->
            val getData = getTutorialData()
            with(binding){
                tvTitle.text = getData[itPosition].title
                ivIntroView.setImageResource(getData[itPosition].drawable)
            }

        }
    }

    private fun getTutorialData():ArrayList<SplashUiModel>{
        val dataList = ArrayList<SplashUiModel>()
        dataList.add(SplashUiModel("Socially",R.drawable.ic_hero_img))
        dataList.add(SplashUiModel("Socially",R.drawable.ic_hero2_img))
        dataList.add(SplashUiModel("Socially",R.drawable.ic_hero2_img))
        return dataList
    }

}