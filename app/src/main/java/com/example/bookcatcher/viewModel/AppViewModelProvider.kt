package com.example.bookcatcher.viewModel

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookcatcher.BookCatcherApplication

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer { MainScreenViewModel(
            this.createSavedStateHandle(),
            bookCatcherApplication().container.booksRepository
        ) }
    }
}
fun CreationExtras.bookCatcherApplication(): BookCatcherApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BookCatcherApplication)