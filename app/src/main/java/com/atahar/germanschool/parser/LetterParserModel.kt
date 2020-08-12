package com.atahar.germanschool.parser


data class LetterParserModel (
    val letterId: Int,
    val letterStart: ArrayList<String>,
    val letterQuestion: ArrayList<String>,
    var letterAnswer: ArrayList<String>,
    var letterEnd: ArrayList<String>
)