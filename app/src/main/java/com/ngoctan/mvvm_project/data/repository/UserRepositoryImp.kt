package com.ngoctan.mvvm_project.data.repository

import com.ngoctan.mvvm_project.data.local.database.AppDataBase
import com.ngoctan.mvvm_project.data.model.user.User
import com.ngoctan.mvvm_project.data.local.database.UserDao
import com.ngoctan.mvvm_project.domain.reponsitory.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepositoryImp: UserRepository {
    private val userDao: UserDao = AppDataBase.getDatabase().userDao()

    override fun getUser(): Flow<List<User>> = flow {
        emit(userDao.getUser())
    }.flowOn(Dispatchers.IO)

    override suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    override suspend fun deleteAllUser() {
        userDao.deleteAllUser()
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    override fun findUserById(id: Int): Flow<List<User>> = flow {
        emit(userDao.findUserById(id))
    }



}