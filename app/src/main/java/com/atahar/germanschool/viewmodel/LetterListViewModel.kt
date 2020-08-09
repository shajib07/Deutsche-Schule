package com.atahar.germanschool.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atahar.germanschool.db.entity.LetterShortModel

class LetterListViewModel : ViewModel() {

    private val _letterList = MutableLiveData<List<LetterShortModel>>()
    val letterList: LiveData<List<LetterShortModel>>
        get() = _letterList

    init {
        setData()
    }

    fun setData() {

        val wordList = listOf(
            LetterShortModel(
                "Birthday",
                "Formal"
            ),
            LetterShortModel(
                "Birthday",
                "Formal"
            ),
            LetterShortModel(
                "Birthday",
                "Formal"
            ),
            LetterShortModel(
                "Birthday",
                "Formal"
            ),
            LetterShortModel(
                "Birthday",
                "Formal"
            ),
            LetterShortModel(
                "Birthday",
                "Formal"
            ),
            LetterShortModel(
                "Birthday",
                "Formal"
            ),
            LetterShortModel(
                "Birthday",
                "Formal"
            ),
            LetterShortModel(
                "Birthday",
                "Formal"
            )
        )

        _letterList.value = wordList
    }


}