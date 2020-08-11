package com.atahar.germanschool.parser

import com.atahar.germanschool.db.entity.LetterModel

object JsonParser {


    fun parseLetter(list: List<LetterParserModel>): ArrayList<LetterModel> {

        val letterList: ArrayList<LetterModel> = arrayListOf()

        list.forEach { parserModel ->

            val startSize = parserModel.letterStart.size
            var start = ""
            for (i in 0 until startSize) {
                start += parserModel.letterStart[i]
                start += "\n"
            }

            val questionSize = parserModel.letterQuestion.size
            var question = ""
            for (i in 0 until questionSize) {
                question += parserModel.letterQuestion[i]
                question += "\n"
            }

            val answerSize = parserModel.letterAnswer.size
            var answer = ""
            for (i in 0 until answerSize) {
                answer += parserModel.letterAnswer[i]
                answer += "\n"
            }

            val endSize = parserModel.letterEnd.size
            var end = ""
            for (i in 0 until endSize) {
                end += parserModel.letterEnd[i]
                end += "\n"
            }

            letterList.add(
                LetterModel(
                    parserModel.letterId,
                    start,
                    question,
                    answer,
                    end
                )
            )
        }

        return letterList
    }
}