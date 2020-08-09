package com.atahar.germanschool.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atahar.germanschool.db.entity.LetterModel

@Dao
interface LettersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(letterWritingModel: LetterModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(letters: List<LetterModel>)

    @Query("SELECT * FROM letter_sample_table")
    fun getLetterById(): LiveData<List<LetterModel>>

}