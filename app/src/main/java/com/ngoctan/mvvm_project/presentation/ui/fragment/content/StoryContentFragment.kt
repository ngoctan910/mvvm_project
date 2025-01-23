package com.ngoctan.mvvm_project.presentation.ui.fragment.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ngoctan.mvvm_project.data.model.story.StoryObject
import com.ngoctan.mvvm_project.databinding.FragmentContentBinding
import com.ngoctan.mvvm_project.presentation.di.ViewModelModule
import com.ngoctan.mvvm_project.presentation.util.Constant
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StoryContentFragment: Fragment() {
    lateinit var binding: FragmentContentBinding
    private val storyContentViewModel = ViewModelModule.storyContentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<StoryObject>(Constant.STORY_CONTENT)?.let {
            binding.contentStory.text = it.content
            binding.storyName.text = it.name
        }

    }
}