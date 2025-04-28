package com.rk.noteslist.domain.usecase

import com.rk.noteslist.domain.NotesListRepository

class GetNoteByIdUseCase(private val repository: NotesListRepository) {

    fun execute(noteId: Int) {
        repository.getNoteById(noteId)
    }
}