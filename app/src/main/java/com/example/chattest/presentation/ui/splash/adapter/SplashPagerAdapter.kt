package com.example.chattest.presentation.ui.splash.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chattest.presentation.ui.splash.SplashFragment

class SplashPagerAdapter (fragment: Fragment):
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return SplashFragment.getInstance(position)
    }
}