package com.example.chattest.presentation.ui.home.story

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.chattest.R
import com.example.chattest.databinding.FragmentStoryBinding
import com.example.chattest.presentation.base.BaseFragment
import com.example.chattest.presentation.ui.home.story.adapter.StoryViewsAdapter
import com.example.chattest.shared.utils.CubeTransformer


class StoryFragment : BaseFragment<FragmentStoryBinding>(FragmentStoryBinding::inflate) {

    private val args: StoryFragmentArgs by navArgs()
    private lateinit var viewPager: ViewPager2


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val urlList = args.storyList
        if (urlList.isNotEmpty()){
            createViewPagerAdapter(urlList.toList())
        }
    }

    private fun createViewPagerAdapter(list: List<String>) {
        val storyAdapter = StoryViewsAdapter(this, list)
        viewPager = binding.vpStory
        viewPager.setPageTransformer(CubeTransformer())
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.adapter = storyAdapter
        viewPager.offscreenPageLimit = list.size
        val child = viewPager.getChildAt(0)
        if (child is RecyclerView){
            child.overScrollMode = View.OVER_SCROLL_NEVER
        }

    }

}