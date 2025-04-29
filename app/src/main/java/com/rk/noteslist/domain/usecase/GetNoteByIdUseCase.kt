package com.rk.noteslist.domain.usecase

import com.rk.noteslist.domain.NotesListRepository
import com.rk.noteslist.domain.entity.Note

class GetNoteByIdUseCase(private val repository: NotesListRepository) {

    fun execute(noteId: Int): Note {
        return repository.getNoteById(noteId)
    }
}