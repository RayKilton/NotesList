package com.rk.noteslist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rk.noteslist.data.repository.NotesListRepositoryImpl
import com.rk.noteslist.domain.entity.Note
import com.rk.noteslist.domain.usecase.AddNewNoteUseCase
import com.rk.noteslist.domain.usecase.DeleteNoteUseCase
import com.rk.noteslist.domain.usecase.EditNoteUseCase
import com.rk.noteslist.domain.usecase.GetNoteByIdUseCase
import com.rk.noteslist.domain.usecase.GetNoteListUseCase

class MainViewModel : ViewModel() {

    private val repository = NotesListRepositoryImpl    //TODO: Ошибка

    private val addNewNoteUseCase = AddNewNoteUseCase(repository)
    private val deleteNoteUseCase = DeleteNoteUseCase(repository)
    private val editNoteUseCase = EditNoteUseCase(repository)
    private val getNoteByIdUseCase = GetNoteByIdUseCase(repository)
    private val getNoteListUseCase = GetNoteListUseCase(repository)

    val noteList = getNoteListUseCase.execute()

    fun addNewNote(note: Note) {
        addNewNoteUseCase.execute(note)
    }

    fun deleteNote(note: Note){
        deleteNoteUseCase.execute(note)
    }

    fun editNoteStatus(note: Note) {
        val newNote = note.copy(status = !note.status)
        editNoteUseCase.execute(newNote)
    }

    fun editNoteInfo() {

    }

    fun getNoteById(noteId: Int): Note{
        return getNoteByIdUseCase.execute(noteId)
    }

}