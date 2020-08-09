package com.atahar.germanschool.listener

import com.atahar.germanschool.db.entity.LetterShortModel

interface LetterListClickListener {

    fun onItemClick(letterShortModel: LetterShortModel)
}