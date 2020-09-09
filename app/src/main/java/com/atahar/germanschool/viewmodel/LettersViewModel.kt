package com.atahar.germanschool.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atahar.germanschool.R
import com.atahar.germanschool.db.entity.LetterModel
import com.atahar.germanschool.repository.LettersRepository

class LettersViewModel(
    private val repository: LettersRepository,
    private val letterId: Int
) : ViewModel() {

    val letter = MutableLiveData<LetterModel>()

    var questranslateOn = MutableLiveData(false)
    var anstranslateOn = MutableLiveData(false)

    fun questionClicked() {
        questranslateOn.value = questranslateOn.value == false
//        onTitleChange.value = translateOn.value
    }

    fun ansClicked() {

        anstranslateOn.value = anstranslateOn.value == false
    }

    fun getExpandIcon() = R.drawable.ic_arrow_down_24px
    fun getCollapseIcon() = R.drawable.ic_arrow_up_24px

//    var onTitleChange = MutableLiveData<Boolean>()

    fun getLetters(): LiveData<List<LetterModel>> {
        return repository.getLetters()
    }

    fun getLetterById(): LiveData<LetterModel> {
        return repository.getLetterById(letterId)
    }

}