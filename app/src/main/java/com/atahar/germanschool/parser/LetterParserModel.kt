package com.atahar.germanschool.parser


data class LetterParserModel (
    val letterId: Int,
    val letterStart: ArrayList<String>,
    val letterQuestion: ArrayList<String>,
    val letterTopic: ArrayList<String>,
    var letterAnswer: ArrayList<String>,
    var letterEnd: ArrayList<String>,
    val letterStartEn: ArrayList<String>,
    val letterTopicEn: ArrayList<String>,
    val letterQuestionEn: ArrayList<String>,
    var letterAnswerEn: ArrayList<String>,
    var letterEndEn: ArrayList<String>
)