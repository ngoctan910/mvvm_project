package com.ngoctan.mvvm_project.presentation.ui.fragment.user

import android.widget.EditText
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ngoctan.mvvm_project.data.model.user.User
import com.ngoctan.mvvm_project.presentation.di.AppRepositoryModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private var userRepository = AppRepositoryModule.userRepository
    private var _user: MutableStateFlow<List<User>> = MutableStateFlow(listOf())
    val user: MutableStateFlow<List<User>> = _user

    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }

    fun getUser() {
        viewModelScope.launch {
            userRepository.getUser().collect { users ->
                _user.value = users
            }
        }
    }

    fun deleteUser() {
        viewModelScope.launch {
            userRepository.deleteAllUser()
        }
    }

    fun findUserbyId(id: Int) {
        viewModelScope.launch {
            userRepository.findUserById(id).collect { id ->
                _user.value = id
            }
        }
    }


}