package com.atahar.germanschool.listener

import com.atahar.germanschool.db.entity.LetterShortModel
import com.atahar.germanschool.model.LetterListItem

interface LetterListClickListener {

    fun onItemClick(letterListItem: LetterListItem)
}