package com.ngoctan.mvvm_project.presentation.di

import com.ngoctan.mvvm_project.presentation.ui.fragment.content.StoryContentViewModel
import com.ngoctan.mvvm_project.presentation.ui.fragment.home.HomeViewModel
import com.ngoctan.mvvm_project.presentation.ui.fragment.story.StoryViewModel
import com.ngoctan.mvvm_project.presentation.ui.fragment.topic.StoryTopicViewModel
import com.ngoctan.mvvm_project.presentation.ui.fragment.user.UserViewModel

object ViewModelModule {
    val homeViewModel by lazy {
        HomeViewModel()
    }

    val userViewModel by lazy {
        UserViewModel()
    }

    val storyTopicViewModel by lazy {
        StoryTopicViewModel()
    }

    val storyViewModel by lazy {
        StoryViewModel()
    }

    val storyContentViewModel by lazy {
        StoryContentViewModel()
    }

}