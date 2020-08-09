package com.atahar.germanschool.repository

import androidx.lifecycle.LiveData
import com.atahar.germanschool.db.dao.LettersShortDao
import com.atahar.germanschool.db.entity.LetterShortModel

class LettersShortRepository private constructor(
    private val lettersShortDao: LettersShortDao
) {

    fun getShortLetters(): LiveData<List<LetterShortModel>> {
        return lettersShortDao.getAllShortLetters()
    }


    companion object {

        private var instance: LettersShortRepository? = null

        fun getInstance(lettersShortDao: LettersShortDao) =
            instance ?: synchronized(this) {
                instance ?: LettersShortRepository(lettersShortDao).also { instance = it }
            }

    }
}