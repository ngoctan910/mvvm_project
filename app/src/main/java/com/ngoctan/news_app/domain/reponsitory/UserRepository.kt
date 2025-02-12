package com.ngoctan.news_app.domain.reponsitory

import com.ngoctan.news_app.data.model.user.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(): Flow<List<User>>

    suspend fun insertUser(user: User)

    suspend fun deleteAllUser()

    suspend fun deleteUser(user: User)

    fun findUserById(id: Int): Flow<List<User>>

}