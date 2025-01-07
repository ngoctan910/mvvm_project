package com.ngoctan.mvvm_project.domain.reponsitory

import com.ngoctan.mvvm_project.data.model.user.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(): Flow<List<User>>

    suspend fun insertUser(user: User)

    suspend fun deleteAllUser()

    suspend fun deleteUser(user: User)

    fun findUserById(id: Int): Flow<List<User>>

}