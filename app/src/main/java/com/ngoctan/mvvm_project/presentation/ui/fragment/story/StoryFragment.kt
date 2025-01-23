package com.ngoctan.mvvm_project.presentation.ui.fragment.story

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ngoctan.mvvm_project.R
import com.ngoctan.mvvm_project.data.model.story.StoryModel
import com.ngoctan.mvvm_project.data.model.story.StoryObject
import com.ngoctan.mvvm_project.databinding.FragmentTitleBinding
import com.ngoctan.mvvm_project.presentation.di.ViewModelModule
import com.ngoctan.mvvm_project.presentation.ui.fragment.content.StoryContentFragment
import com.ngoctan.mvvm_project.presentation.util.Constant
import kotlinx.coroutines.launch

class StoryFragment: Fragment() {
    lateinit var binding: FragmentTitleBinding
    private val storyViewModel = ViewModelModule.storyViewModel
    lateinit var storyAdapter: StoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTitleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val topicName = arguments?.getString(Constant.TOPIC_KEY)
        binding.topicName.text = topicName.toString()

        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }


        storyAdapter = StoryAdapter(listOf())
        binding.recyclerview.adapter = storyAdapter

        storyAdapter.onClickItem = { story ->
            val bundle = Bundle()
            bundle.putParcelable(Constant.STORY_CONTENT, story)
            StoryContentFragment().arguments = bundle
            findNavController().navigate(R.id.action_from_storyFragment_to_storyContentFragment, bundle)
        }

        lifecycleScope.launch {
            storyViewModel.story.collect { storyModel ->
                storyModel?.let {
                    val listStory = when (topicName) {
                        "Y te" -> it.yTe
                        "Vova" -> it.vova
                        "Viet Nam va the gioi" -> it.vietNamVaTheGioi
                        else -> listOf()
                    }

                    storyAdapter.submitList(listStory)
                }
            }
        }

        storyViewModel.getNameStory()
    }


}