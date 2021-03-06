package com.atahar.germanschool.repository

import androidx.lifecycle.LiveData
import com.atahar.germanschool.db.dao.LettersDao
import com.atahar.germanschool.db.entity.LetterModel

class LettersRepository private constructor(private val lettersDao: LettersDao) {

    fun getLetters(): LiveData<List<LetterModel>> {
        return lettersDao.getLetters()
    }

    fun getLetterById(letterId: Int): LiveData<LetterModel> {
        return lettersDao.getLetterById(letterId)
    }

    companion object {

        @Volatile
        private var instance: LettersRepository? = null

        fun getInstance(lettersDao: LettersDao) =
            instance ?: synchronized(this) {
                instance ?: LettersRepository(lettersDao).also { instance = it }
            }

    }
}