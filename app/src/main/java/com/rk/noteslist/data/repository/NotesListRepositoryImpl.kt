package com.rk.noteslist.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rk.noteslist.domain.NotesListRepository
import com.rk.noteslist.domain.entity.Note
import com.rk.noteslist.domain.entity.Note.Companion.UNDEFINED_ID

object NotesListRepositoryImpl: NotesListRepository{

    private val noteListLiveData = MutableLiveData<List<Note>>()
    private val noteList = mutableListOf<Note>()

    var countOfNote = 1

    override fun addNewNote(note: Note) {
        if (note.id == UNDEFINED_ID){
            note.id = countOfNote++
        }
        noteList.add(note)
        updateList()
    }

    override fun editNote(note: Note) {
        val oldNote = getNoteById(note.id)
        noteList.remove(oldNote)
        addNewNote(note)
    }

    override fun deleteNote(note: Note) {
        noteList.remove(note)
        updateList()
    }

    override fun getNoteById(noteId: Int): Note{
        return noteList.find {
            it.id == noteId
        } ?: throw RuntimeException("Element with id $noteId not found")
    }

    override fun getNoteList(): LiveData<List<Note>> {
        return noteListLiveData
    }

    fun updateList() {
        noteListLiveData.value = noteList.toList()
    }
}