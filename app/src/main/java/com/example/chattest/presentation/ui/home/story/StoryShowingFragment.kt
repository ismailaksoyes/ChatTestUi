package com.example.chattest.presentation.ui.home.story

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.chattest.databinding.FragmentStoryShowingBinding
import com.example.chattest.presentation.base.BaseFragment


class StoryShowingFragment : BaseFragment<FragmentStoryShowingBinding>(FragmentStoryShowingBinding::inflate) {

    private lateinit var webView: WebView

    companion object {
        private const val ARG_URL = "ARG_URL"

        fun getInstance(url: String) = StoryShowingFragment().apply {
            arguments = bundleOf(ARG_URL to url)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWebView()
        val url = requireArguments().getString(ARG_URL)
        openWebUrl(url)
        closeStoryOb()
    }

    private fun openWebUrl(url: String?){
        url?.let { itUrl->
            webView.loadUrl(itUrl)
        }
    }

    private fun closeStoryOb(){
        binding.ivCloseStory.setOnClickListener {
            val action = StoryFragmentDirections.actionStoryFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }


    private fun setupWebView() {
        webView = binding.webView
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.javaScriptCanOpenWindowsAutomatically = false
        webView.settings.setSupportZoom(true)
        webView.settings.domStorageEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.setBackgroundColor(Color.TRANSPARENT)
        webView.settings.loadsImagesAutomatically = true
    }

}