package com.ngoctan.mvvm_project.data.model.story

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoryObject(
    var id: Int,
    var name: String,
    var content: String
): Parcelable

