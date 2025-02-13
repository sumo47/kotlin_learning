package com.example.roomdatabase

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.roomdatabase.roomDb.Note
import com.example.roomdatabase.roomDb.NoteDatabase
import com.example.roomdatabase.ui.theme.RoomDatabaseTheme
import com.example.roomdatabase.viewModel.NoteViewModel
import com.example.roomdatabase.viewModel.Repository

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            "note.db"  // Removed `name =` as it's redundant
        ).build()
    }

    private val viewModel by viewModels<NoteViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return NoteViewModel(Repository(db)) as T  // Explicit cast applied correctly
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDatabaseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var name by remember {
                        mutableStateOf("")
                    }
                    var body by remember {
                        mutableStateOf("")
                    }
                    var note = Note(
                        name,
                        body
                    )
                    var noteList by remember {
                        mutableStateOf(listOf<Note>())
                    }
                    viewModel.getNotes().observe(this) {
                        noteList = it
                    }

                    Column(
                        Modifier
                            .padding(12.dp)
                            .fillMaxSize(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = {
                            viewModel.upsertNote(note)
                        }) {
                            Text(text = "Save")
                        }

                        Spacer(Modifier.padding(8.dp))

                        TextField(
                            value = name,
                            onValueChange = { name = it },
                            placeholder = { Text(text = "Enter name") })

                        Spacer(Modifier.padding(8.dp))

                        TextField(
                            value = body,
                            onValueChange = { body = it },
                            placeholder = { Text(text = "Enter body") })
                        Spacer(Modifier.padding(10.dp))

//                        LazyColumn {
//                            items(noteList) { note ->
//                                Column {
//                                    Text(text = "Name: ${note.noteName}")
//                                    Spacer(Modifier.height(6.dp))
//                                    Text(text = "Body: ${note.noteBody}")
//                                    Divider(
//                                        Modifier
//                                            .fillMaxWidth()
//                                            .padding(6.dp)
//                                    )
//                                }
//                            }
//                        }
                        LazyColumn(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            items(noteList) { note ->
                                Card(// appearance and behavior
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 8.dp),
                                    shape = RoundedCornerShape(12.dp),
                                    elevation = CardDefaults.cardElevation(4.dp),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .padding(16.dp)
                                    ) {
                                        Text(
                                            text = "📌 ${note.noteName}",
                                            style = MaterialTheme.typography.titleMedium,
                                            color = MaterialTheme.colorScheme.primary
                                        )

                                        Spacer(Modifier.height(4.dp))

                                        Text(
                                            text = note.noteBody,
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )

                                        Spacer(Modifier.height(8.dp))

                                        Divider(color = MaterialTheme.colorScheme.secondary, thickness = 1.dp)
                                    }
                                }
                            }
                        }


                    }

                }
            }
        }
    }
}
