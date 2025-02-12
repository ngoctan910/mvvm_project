package com.ngoctan.news_app.presentation.ui.fragment.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ngoctan.news_app.data.model.story.StoryObject
import com.ngoctan.news_app.databinding.FragmentContentBinding
import com.ngoctan.news_app.presentation.util.Constant

class StoryContentFragment: Fragment() {
    lateinit var binding: FragmentContentBinding

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

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

    }
}