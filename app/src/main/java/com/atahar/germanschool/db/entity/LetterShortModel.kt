package com.atahar.germanschool.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "letter_short_table")
data class LetterShortModel(

    @PrimaryKey
    @ColumnInfo(name = "letter_id")
    val letterId: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "category")
    val category: String
)