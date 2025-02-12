package com.ngoctan.news_app.presentation.ui.fragment.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ngoctan.news_app.R
import com.ngoctan.news_app.databinding.FragmentStoryTopicBinding
import com.ngoctan.news_app.presentation.di.ViewModelModule
import com.ngoctan.news_app.presentation.ui.fragment.story.StoryFragment
import com.ngoctan.news_app.presentation.util.Constant


class StoryTopicFragment: Fragment() {
    lateinit var binding: FragmentStoryTopicBinding
    private var storyViewModel = ViewModelModule.storyTopicViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoryTopicBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        (activity as MainActivity).navigateWithAction(2, bundle = Bundle())
        binding.apply {
            ivVN.setOnClickListener {
                navigateToStoryFragment(nameTopic = "Viet Nam va the gioi")
            }

            ivYt.setOnClickListener {
                navigateToStoryFragment(nameTopic = "Y te")
            }

            ivVova.setOnClickListener {
                navigateToStoryFragment(nameTopic = "Vova")
            }
        }
    }

    private fun navigateToStoryFragment(nameTopic: String) {
        val bundle = Bundle()
        bundle.putString(Constant.TOPIC_KEY, nameTopic)
        StoryFragment().arguments = bundle
        findNavController().navigate(R.id.action_from_topicFragment_to_storyFragment, bundle)
    }
}