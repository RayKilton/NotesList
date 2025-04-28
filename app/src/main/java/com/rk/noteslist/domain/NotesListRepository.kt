package com.rk.noteslist.domain

import com.rk.noteslist.domain.entity.Note

interface NotesListRepository {

    fun addNewNote(note: Note)
    fun changeNoteInfo(note: Note)
    fun changeNoteStatus(note: Note)
    fun deleteNote(note: Note)
    fun getNoteById(noteId: Int)
}