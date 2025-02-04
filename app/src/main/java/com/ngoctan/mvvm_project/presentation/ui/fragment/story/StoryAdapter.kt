package com.ngoctan.mvvm_project.presentation.ui.fragment.story

import android.graphics.ColorSpace.Model
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ngoctan.mvvm_project.data.model.story.StoryModel
import com.ngoctan.mvvm_project.data.model.story.StoryObject
import com.ngoctan.mvvm_project.databinding.ItemTitleStoryBinding

class StoryAdapter(
    private var storyList: List<StoryObject>
): RecyclerView.Adapter<StoryAdapter.TopicStoryViewHolder>() {
        var onClickItem: ((StoryObject) -> Unit)? = null
        private lateinit var binding: ItemTitleStoryBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicStoryViewHolder {
        binding = ItemTitleStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopicStoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    override fun onBindViewHolder(holder: TopicStoryViewHolder, position: Int) {
        val storyObject = storyList[position]
        holder.onBind(storyObject)
        holder.itemView.setOnClickListener {
            onClickItem?.invoke(storyObject)
        }
    }

    fun submitList(listStory: List<StoryObject>) {
        storyList = listStory
        notifyDataSetChanged()
    }

    inner class TopicStoryViewHolder(private var binding: ItemTitleStoryBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(storyObject: StoryObject) {
            binding.tvNameStory.text = storyObject.name

        }

    }
}


