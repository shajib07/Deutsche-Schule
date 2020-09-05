package com.atahar.germanschool.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "letter_sample_table")
data class LetterModel (

    @PrimaryKey
    @ColumnInfo(name = "letter_id")
    val letterId: Int,

    @ColumnInfo(name = "letter_start")
    var letterStart: String,

    @ColumnInfo(name = "letter_topic")
    val letterTopic: String,

    @ColumnInfo(name = "letter_question")
    val letterQuestion: String,

    @ColumnInfo(name = "letter_answer")
    var letterAnswer: String,

    @ColumnInfo(name = "letter_end")
    var letterEnd: String,

    @ColumnInfo(name = "letter_start_en")
    var letterStartEn: String,

    @ColumnInfo(name = "letter_Topic_en")
    val letterTopicEn: String,

    @ColumnInfo(name = "letter_question_en")
    val letterQuestionEn: String,

    @ColumnInfo(name = "letter_answer_en")
    var letterAnswerEn: String,

    @ColumnInfo(name = "letter_end_en")
    var letterEndEn: String
)