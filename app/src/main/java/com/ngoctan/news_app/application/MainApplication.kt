package com.ngoctan.news_app.application

import android.app.Application

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