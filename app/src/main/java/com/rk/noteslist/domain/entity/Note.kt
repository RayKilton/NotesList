package com.rk.noteslist.domain.entity

data class Note(
    val id: Int = UNDEFINED_ID,
    val title: String,
    val textContent: String,
    val status: Boolean,
    val remindDate: Long?,      //для хранения даты напоминания, удобно работать с БД
) {

    companion object{
        const val UNDEFINED_ID = -1
    }
}