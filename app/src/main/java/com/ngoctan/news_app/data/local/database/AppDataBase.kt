package com.ngoctan.news_app.data.local.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ngoctan.news_app.application.MainApplication
import com.ngoctan.news_app.data.model.user.User


@Database(entities = [User::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDataBase? = null

        fun getDatabase(): AppDataBase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    MainApplication.getInstance().applicationContext,
                    AppDataBase::class.java,
                    "user_database"
                ).build()
            }
        }
    }
}