package com.atahar.germanschool.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atahar.germanschool.db.entity.LetterShortModel
import com.atahar.germanschool.repository.LettersShortRepository

class LetterListViewModel(private val lettersShortRepository: LettersShortRepository) : ViewModel() {

    val shortLetters = MutableLiveData<List<LetterShortModel>>()

    init {
        getShortLetters()
    }

    fun getShortLetters(): LiveData<List<LetterShortModel>> {
        return lettersShortRepository.getShortLetters()
    }

}