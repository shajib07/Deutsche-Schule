package com.atahar.germanschool.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "letter_sample_table")
data class LetterModel (

    @PrimaryKey
    @ColumnInfo(name = "letter_id")
    val letterId: Int,

    @ColumnInfo(name = "letter_question")
    val letterQuestion: String,

    @ColumnInfo(name = "letter_answer")
    val letterAnswer: String
)