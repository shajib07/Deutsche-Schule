package com.atahar.germanschool.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.atahar.germanschool.db.dao.LettersDao
import com.atahar.germanschool.db.dao.LettersShortDao
import com.atahar.germanschool.db.entity.LetterModel
import com.atahar.germanschool.db.entity.LetterShortModel
import com.atahar.germanschool.db.typeconverter.KeywordConverter
import com.atahar.germanschool.workers.DBInsertWorker

@Database(entities = [LetterModel::class, LetterShortModel::class], version = 1, exportSchema = false)
@TypeConverters(KeywordConverter::class)
abstract class GermanSchoolDatabase : RoomDatabase() {

    abstract val lettersDao: LettersDao
    abstract val lettersShortDao: LettersShortDao

    private class GermanSchoolDatabaseCallback(
        private val context: Context
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val request = OneTimeWorkRequestBuilder<DBInsertWorker>().build()
            WorkManager.getInstance(context).enqueue(request)
        }
    }

    companion object {

        private var INSTANCE: GermanSchoolDatabase? = null

        fun getInstance(context: Context): GermanSchoolDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GermanSchoolDatabase::class.java,
                        "german_school_database"
                    )
                        .addCallback(GermanSchoolDatabaseCallback(context))
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }

    }
}
