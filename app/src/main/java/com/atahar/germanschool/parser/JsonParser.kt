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

            val topicSize = parserModel.letterTopic.size
            var topic = ""
            for (i in 0 until topicSize) {
                if (i != 0) topic += "\n"
                topic += parserModel.letterTopic[i]
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

            val startSizeEn = parserModel.letterStartEn.size
            var startEn = ""
            for (i in 0 until startSizeEn) {
                if (i != 0) startEn += "\n"
                startEn += parserModel.letterStartEn[i]
            }

            val topicSizeEn = parserModel.letterTopicEn.size
            var topicEn = ""
            for (i in 0 until topicSizeEn) {
                if (i != 0) topicEn += "\n"
                topicEn += parserModel.letterTopicEn[i]
            }

            val questionSizeEn = parserModel.letterQuestionEn.size
            var questionEn = ""
            for (i in 0 until questionSizeEn) {
                if (i != 0) questionEn += "\n"
                questionEn += parserModel.letterQuestionEn[i]
            }

            val answerSizeEn = parserModel.letterAnswerEn.size
            var answerEn = ""
            for (i in 0 until answerSizeEn) {
                if (i != 0) answerEn += "\n"
                answerEn += parserModel.letterAnswerEn[i]
            }

            val endSizeEn = parserModel.letterEndEn.size
            var endEn = ""
            for (i in 0 until endSizeEn) {
                if (i != 0) endEn += "\n"
                endEn += parserModel.letterEndEn[i]
            }

            letterList.add(
                LetterModel(
                    parserModel.letterId,
                    start,
                    topic,
                    question,
                    answer,
                    end,
                    startEn,
                    topicEn,
                    questionEn,
                    answerEn,
                    endEn
                )
            )
        }

        return letterList
    }
}