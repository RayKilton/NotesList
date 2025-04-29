package com.rk.noteslist.domain

import androidx.lifecycle.LiveData
import com.rk.noteslist.domain.entity.Note

interface NotesListRepository {

    fun addNewNote(note: Note)
    fun editNote(note: Note)
    fun deleteNote(note: Note)
    fun getNoteById(noteId: Int): Note
    fun getNoteList(): LiveData<List<Note>>
}