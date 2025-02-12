package com.ngoctan.news_app.presentation.ui.fragment.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ngoctan.news_app.data.model.story.StoryModel
import com.ngoctan.news_app.presentation.di.AppRepositoryModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StoryContentViewModel: ViewModel() {
    private val appRepository = AppRepositoryModule.appRepository
    private var _contentStory: MutableStateFlow<StoryModel?> = MutableStateFlow(null)
    val contentStory: StateFlow<StoryModel?> = _contentStory

    fun getContentStory() {
        viewModelScope.launch {
            appRepository.getStories().collect { storyModel ->
                _contentStory.value = storyModel
            }
        }
    }
}