package com.ngoctan.news_app.presentation.ui.fragment.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ngoctan.news_app.data.model.user.User
import com.ngoctan.news_app.databinding.FragmentUserBinding
import com.ngoctan.news_app.presentation.di.ViewModelModule
import kotlinx.coroutines.launch

class UserFragment: Fragment() {
    lateinit var binding: FragmentUserBinding
    val userViewModel = ViewModelModule.userViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            userViewModel.user.collect {
                binding.tvShow.text = it.toString()
            }
        }

        binding.btnInsert.setOnClickListener {
            userViewModel.insertUser(user = User(binding.edtId.text.toString().toInt(), binding.edtName.text.toString(),
                                                 binding.edtAge.text.toString().toInt()))
        }

        binding.btnGet.setOnClickListener {
            userViewModel.getUser()
        }

        binding.btnDelete.setOnClickListener {
            userViewModel.deleteUser()
        }

        binding.btnFind.setOnClickListener {
            userViewModel.findUserbyId(id = binding.edtId.text.toString().toInt())
        }
    }
}