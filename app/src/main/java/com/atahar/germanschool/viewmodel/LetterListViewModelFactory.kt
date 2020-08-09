package com.atahar.germanschool.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atahar.germanschool.repository.LettersShortRepository
import java.lang.IllegalArgumentException

class LetterListViewModelFactory(val lettersShortRepository: LettersShortRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LetterListViewModel::class.java))
            return LetterListViewModel(lettersShortRepository) as T

        throw IllegalArgumentException("Unknown Model class")
    }


}