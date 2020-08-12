package com.atahar.germanschool.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.atahar.germanschool.model.LetterListItem

@Entity(tableName = "letter_short_table")
data class LetterShortModel(

    @PrimaryKey
    @ColumnInfo(name = "letter_id")
    val letterId: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "category")
    val category: String,

    @ColumnInfo(name = "keywords")
    val keywords: List<String>
)

fun List<LetterShortModel>.asDomainModel(): List<LetterListItem> {
    return map {
        LetterListItem(
            letterId = it.letterId,
            title = it.title,
            category = it.category,
            keywords = it.keywords.joinToString()
        )
    }
}
