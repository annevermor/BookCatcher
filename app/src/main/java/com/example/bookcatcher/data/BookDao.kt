package com.example.bookcatcher.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book: Book)

    @Update
    suspend fun update(book: Book)

    @Delete
    suspend fun delete(book: Book)

    @Query("SELECT * from books WHERE id = :id")
    fun getBook(id: Int): Flow<Book>

    @Query("SELECT * from books ORDER by title ASC")
    fun getAllBooks(): Flow<List<Book>>
}