package com.example.bookcatcher.viewModel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookcatcher.BookCatcherApplication
import com.example.bookcatcher.data.Book
import com.example.bookcatcher.data.BookDao
import com.example.bookcatcher.data.BookDatabase
import com.example.bookcatcher.data.BooksRepository
import com.example.bookcatcher.data.OfflineBooksRepository
import com.example.bookcatcher.data.ReadingPos
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

data class MainScreenUiState(
    val number: Int = 0
)

class MainScreenViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {
    var mainScreenUiState by mutableStateOf(MainScreenUiState())
        private set

    fun reduceNum() {
        mainScreenUiState = MainScreenUiState(
            number = mainScreenUiState.number + 1
        )
    }

    suspend fun addBook() {
//        booksRepository.insertBook(
//            Book(title = "asd", author = "qwe", pageNumbers = 1, currentPage = 0)
//        )
        booksRepository.deletePosition(ReadingPos(bookId = 1, date = "01.24.2024", position = 0))
    }

    suspend fun deleteBook() {
        booksRepository.deleteBook(
            Book(id = 1, title = "asd", author = "qwe", pageNumbers = 1, currentPage = 0)
        )
    }
}