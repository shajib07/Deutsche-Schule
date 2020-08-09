package com.atahar.germanschool.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atahar.germanschool.repository.LettersRepository
import java.lang.IllegalArgumentException

class LettersViewModelFactory(
    private val repository: LettersRepository,
    private val letterId: Int
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LettersViewModel::class.java))
            return LettersViewModel(repository, letterId) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}