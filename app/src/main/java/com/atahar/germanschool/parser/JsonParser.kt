package com.atahar.germanschool.parser

import com.atahar.germanschool.db.entity.LetterModel

object JsonParser {


    fun parseLetter(list: List<LetterParserModel>): ArrayList<LetterModel> {

        val letterList: ArrayList<LetterModel> = arrayListOf()

        list.forEach { parserModel ->

            val startSize = parserModel.letterStart.size
            var start = ""
            for (i in 0 until startSize) {
                if (i != 0) start += "\n"
                start += parserModel.letterStart[i]
            }

            val questionSize = parserModel.letterQuestion.size
            var question = ""
            for (i in 0 until questionSize) {
                if (i != 0) question += "\n"
                question += parserModel.letterQuestion[i]
            }

            val answerSize = parserModel.letterAnswer.size
            var answer = ""
            for (i in 0 until answerSize) {
                if (i != 0) answer += "\n"
                answer += parserModel.letterAnswer[i]
            }

            val endSize = parserModel.letterEnd.size
            var end = ""
            for (i in 0 until endSize) {
                if (i != 0) end += "\n"
                end += parserModel.letterEnd[i]
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