package com.example.bookcatcher

import android.app.Application
import com.example.bookcatcher.data.AppContainer
import com.example.bookcatcher.data.AppDataContainer
import com.example.bookcatcher.data.Book
import kotlinx.coroutines.coroutineScope

class BookCatcherApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}