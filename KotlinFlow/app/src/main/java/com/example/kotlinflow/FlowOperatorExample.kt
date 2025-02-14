package com.example.kotlinflow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

fun getNotes(): Flow<Note> {
    val list = listOf(
        Note(1, true, "First", "First Description"),
        Note(2, true, "Second", "Second Description"),
        Note(3, true, "Third", "Third Description"),
        Note(4, false, "Fourth", "Fourth Description"),
        Note(5, true, "Fifth", "Fifth Description"),
    )
    return list.asFlow() // asFlow is use to convert list to flow
}

data class Note(val id: Int, val isActive: Boolean, val title: String, val description: String)
data class FormattedNote(val isActive: Boolean, val title: String, val description: String)