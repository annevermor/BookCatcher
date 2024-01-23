package com.example.bookcatcher.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val author: String,
    val pageNumbers: Int,
    val currentPage: Int
)

@Entity(
    tableName = "reading_pos", foreignKeys = [ForeignKey(
        entity = Book::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("book_id"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class ReadingPos(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "book_id", index = true) val bookId: Int,
    val position: Int,
    val date: String
)