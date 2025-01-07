package com.ngoctan.mvvm_project.application

import android.app.Application
import androidx.room.Room
import com.ngoctan.mvvm_project.data.local.database.AppDataBase

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private var instance: MainApplication? = null

        fun getInstance(): MainApplication {
            if (instance == null)
                instance = MainApplication()

            return instance!!
        }
    }
}