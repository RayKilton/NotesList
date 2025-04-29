package com.rk.noteslist.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rk.noteslist.R
import com.rk.noteslist.domain.entity.Note

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        while (count < 4) {
            val newNote = Note(-1, "Сделать ДЗ $count", " ", false, 0)
            viewModel.addNewNote(newNote)
            count++
            Log.d("MainActivity1", viewModel.noteList.toString())
        }
        viewModel.noteList.observe(this) { noteList ->
            if(count == 4)
            viewModel.noteList.value?.let { list ->
                val note = list[1]
                viewModel.editNoteStatus(note)
                count++
            }
            Log.d("MainActivity2", noteList.toString())
        }
    }
}