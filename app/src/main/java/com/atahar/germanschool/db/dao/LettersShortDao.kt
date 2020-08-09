package com.atahar.germanschool.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atahar.germanschool.db.entity.LetterShortModel

@Dao
interface LettersShortDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(shortLetters: List<LetterShortModel>)

    @Query("SELECT * from letter_short_table")
    fun getAllShortLetters(): LiveData<List<LetterShortModel>>

}