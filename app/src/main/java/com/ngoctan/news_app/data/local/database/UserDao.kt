package com.ngoctan.news_app.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ngoctan.news_app.data.model.user.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE uid LIKE :id")
    suspend fun findUserById(id: Int): List<User>

    @Query("SELECT * FROM user")
    suspend fun getUser(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(vararg users: User)

    @Delete
    suspend fun deleteUser(vararg user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAllUser()

}