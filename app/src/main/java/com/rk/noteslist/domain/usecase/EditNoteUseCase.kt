package com.rk.noteslist.domain.usecase

import com.rk.noteslist.domain.NotesListRepository
import com.rk.noteslist.domain.entity.Note

class EditNoteUseCase(private val repository: NotesListRepository) {

    fun execute(note: Note) {
        repository.editNote(note)
    }
}