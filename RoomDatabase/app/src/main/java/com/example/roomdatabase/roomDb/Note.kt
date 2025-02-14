package com.example.roomdatabase.roomDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity // entry point
data class Note(
    val noteName: String,
    val noteBody: String,
    @PrimaryKey(autoGenerate = true)
    val noteId: Int = 0,
)
@Entity // entry point
data class User(
    val noteName: String,
    val noteBody: String,
    @PrimaryKey(autoGenerate = true)
    val noteId: Int = 0,
)
