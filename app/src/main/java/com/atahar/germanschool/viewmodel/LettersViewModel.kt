package com.atahar.germanschool.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atahar.germanschool.db.entity.LetterModel
import com.atahar.germanschool.repository.LettersRepository

class LettersViewModel(
    val repository: LettersRepository,
    val letterId: Int
) : ViewModel() {

    val letter = MutableLiveData<LetterModel>()

    fun getLetters(): LiveData<List<LetterModel>> {
        return repository.getLetterById()
    }

}