package com.example.chattest.presentation.ui.home.story.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chattest.presentation.ui.home.story.StoryShowingFragment

class StoryViewsAdapter(fragment:Fragment, private val urlList: List<String>): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return urlList.size
    }

    override fun createFragment(position: Int): Fragment {
        return StoryShowingFragment.getInstance(urlList[position])
    }

}