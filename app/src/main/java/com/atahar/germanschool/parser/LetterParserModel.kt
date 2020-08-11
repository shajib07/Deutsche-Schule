package com.atahar.germanschool.parser


data class LetterParserModel (
    val letterId: Int,
    val letterStart: Array<String>,
    val letterQuestion: Array<String>,
    var letterAnswer: Array<String>,
    var letterEnd: Array<String>
)