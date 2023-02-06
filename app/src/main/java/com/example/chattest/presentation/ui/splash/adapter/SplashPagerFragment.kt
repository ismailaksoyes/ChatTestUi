package com.example.chattest.presentation.ui.splash.adapter

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.chattest.R
import com.example.chattest.common.extensions.*
import com.example.chattest.databinding.FragmentSplashPagerBinding
import com.example.chattest.presentation.base.BaseFragment
import com.example.chattest.shared.utils.TextColorType


class SplashPagerFragment :
    BaseFragment<FragmentSplashPagerBinding>(FragmentSplashPagerBinding::inflate) {

    private lateinit var viewPager: ViewPager2

    private val splashAdapter by lazy { SplashPagerAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = binding.viewPager2
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.adapter = splashAdapter
        viewPager.registerOnPageChangeCallback(onTutorialPageChangeCallBack)
        binding.springDotsIndicator.attachTo(binding.viewPager2)
        setupPagerClick()
    }

    private var onTutorialPageChangeCallBack = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            getTutorialAnim(position)

        }
    }

    private fun setupPagerClick(){
        binding.ivNext.setOnClickListener {
            when(binding.viewPager2.currentItem){
                0,1->{
                    viewPager.setCurrentItem(binding.viewPager2.currentItem + 1,true)
                }
                2->{
                    val action = SplashPagerFragmentDirections.actionSplashPagerFragmentToHomeFragment()
                    findNavController().navigate(action)
                }
            }

        }
    }

    fun getTutorialAnim(position: Int) {
        when (position) {
            0 -> {
                binding.ivNext.changeColorBlueToBlack()
                binding.ivNextBtn.changeColorBlackToWhite()
                binding.tvNext.textChangeColor(TextColorType.WHITE)

            }
            1 -> {
                binding.ivNext.changeColorBlackToBlue()
                binding.ivNextBtn.changeColorWhiteToBlack()
                binding.tvNext.textChangeColor(TextColorType.BLACK)
            }
            2 -> {
                binding.ivNext.changeColorBlueToBlack()
                binding.ivNextBtn.changeColorBlackToWhite()
                binding.tvNext.textChangeColor(TextColorType.WHITE)

            }


        }
    }

}