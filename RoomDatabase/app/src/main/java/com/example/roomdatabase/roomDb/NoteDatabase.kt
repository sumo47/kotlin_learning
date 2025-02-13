package com.example.roomdatabase.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Note::class],
    version = 1
)

abstract class NoteDatabase: RoomDatabase() {// marked as Room database
    abstract val dao: RoomDao
}