package com.atahar.germanschool.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.atahar.germanschool.db.GermanSchoolDatabase
import com.atahar.germanschool.db.entity.LetterModel
import com.atahar.germanschool.db.entity.LetterShortModel
import com.atahar.germanschool.utils.SAMPLE_LETTER_FILENAME
import com.atahar.germanschool.utils.SAMPLE_LETTER_SHORT_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope

class DBInsertWorker(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result = coroutineScope {

        try {
            applicationContext.assets.open(SAMPLE_LETTER_FILENAME).use { inputStream ->

                JsonReader(inputStream.reader()).use { jsonReader ->

                    val type = object : TypeToken<List<LetterModel>>() {}.type
                    val sampleLetterList: List<LetterModel> =
                        Gson().fromJson(jsonReader, type)

                    val database = GermanSchoolDatabase.getInstance(applicationContext)
                    database.lettersDao.insertAll(sampleLetterList)
                }

            }

            applicationContext.assets.open(SAMPLE_LETTER_SHORT_FILENAME).use { inputStream ->

                JsonReader(inputStream.reader()).use { jsonReader ->

                    val type = object : TypeToken<List<LetterShortModel>>() {}.type
                    val shortLetterList: List<LetterShortModel> =
                        Gson().fromJson(jsonReader, type)

                    val database = GermanSchoolDatabase.getInstance(applicationContext)
                    database.lettersShortDao.insertAll(shortLetterList)
                }
            }

            Result.success()

        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private val TAG = DBInsertWorker::class.java.simpleName
    }
}