package com.ngoctan.news_app.presentation.ui.fragment.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ngoctan.news_app.databinding.FragmentNewsBinding
import com.ngoctan.news_app.presentation.di.ViewModelModule
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NewsFragment: Fragment() {
    private lateinit var binding: FragmentNewsBinding
    val viewModel = ViewModelModule.newsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.currentNews()
    }
}