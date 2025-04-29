package com.rk.noteslist.domain.usecase

import androidx.lifecycle.LiveData
import com.rk.noteslist.domain.NotesListRepository
import com.rk.noteslist.domain.entity.Note

class GetNoteListUseCase (private val repository: NotesListRepository) {

    fun execute(): LiveData<List<Note>> {
        return repository.getNoteList()
    }
}