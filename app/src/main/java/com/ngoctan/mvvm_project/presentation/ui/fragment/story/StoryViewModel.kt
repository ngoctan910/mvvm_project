package com.ngoctan.mvvm_project.presentation.ui.fragment.story

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ngoctan.mvvm_project.data.model.story.StoryModel
import com.ngoctan.mvvm_project.presentation.di.AppRepositoryModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StoryViewModel: ViewModel() {
    private val appRepository = AppRepositoryModule.appRepository
    private var _story: MutableStateFlow<StoryModel?> = MutableStateFlow(null)
    val story: StateFlow<StoryModel?> = _story

    fun getNameStory() {
        viewModelScope.launch {
            appRepository.getStories().collect { storyModel ->
                _story.value = storyModel
            }
        }
    }
}