package com.rk.noteslist.presentation

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rk.noteslist.R
import com.rk.noteslist.domain.entity.Note

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var llNoteList: LinearLayout

    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llNoteList = findViewById(R.id.ll_note_item)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        ///\\\
        while (count < 4) {
            val newNote = Note(-1, "Сделать ДЗ $count", " ", false, 0)
            viewModel.addNewNote(newNote)

        }
        ///\\\
        viewModel.noteList.observe(this) {

        }
    }

    private fun showNoteList(list: List<Note>) {
        for (noteItem in list) {

        }

    }
}