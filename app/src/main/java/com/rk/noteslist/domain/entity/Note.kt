package com.rk.noteslist.domain.entity

data class Note(
    var id: Int = UNDEFINED_ID,
    val title: String,
    val textContent: String,
    var status: Boolean,
    val remindDate: Long?,      //для хранения даты напоминания, удобно работать с БД
) {

    companion object{
        const val UNDEFINED_ID = -1
    }
}