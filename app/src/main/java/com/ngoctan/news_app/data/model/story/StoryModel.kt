package com.ngoctan.news_app.data.model.story

import com.google.gson.annotations.SerializedName

data class StoryModel(
    @SerializedName("y_te")
    var yTe: List<StoryObject>,
    var vova: List<StoryObject>,
    @SerializedName("viet_name_va_the_gioi")
    var vietNamVaTheGioi: List<StoryObject>
)
