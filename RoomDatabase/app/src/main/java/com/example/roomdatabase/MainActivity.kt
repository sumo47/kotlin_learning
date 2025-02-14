package com.example.roomdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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

    private val db by lazy { // execute once , cache result
        Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            "note.db"
        ).build()
    }

    private val viewModel by viewModels<NoteViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return NoteViewModel(Repository(db)) as T
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
                    NotesScreen(viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(viewModel: NoteViewModel) {
    var name by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    var noteList by remember { mutableStateOf(listOf<Note>()) }

    viewModel.getNotes().observeForever {
        noteList = it
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("📒 My Notes", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (name.isNotEmpty() && body.isNotEmpty()) {
                        viewModel.upsertNote(Note(name, body))
                        name = ""
                        body = ""
                    }
                },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add Note", tint = Color.White)
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = body,
                onValueChange = { body = it },
                label = { Text("Note") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            AnimatedVisibility(visible = noteList.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(noteList) { note ->
                        NoteCard(note, viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun NoteCard(note: Note , viewModel :NoteViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
           Row (
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween
           ){
               Text(
                   text = "📌 ${note.noteName}",
                   style = MaterialTheme.typography.titleMedium,
                   fontWeight = FontWeight.Bold,
                   color = MaterialTheme.colorScheme.primary
               )
               Icon(Icons.Filled.Delete,
                   contentDescription = "Delete Note",
                   tint = Color.Red,
                   modifier = Modifier.clickable { viewModel.deleteNote(note) })

           }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = note.noteBody,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            Divider(color = MaterialTheme.colorScheme.secondary, thickness = 1.dp)
        }
    }
}

@Preview
@Composable
fun line (){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ){
        Text(
            text = "📌 this is note",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Icon(Icons.Filled.Delete, contentDescription = "Delete Note", tint = Color.Red)

    }
}
