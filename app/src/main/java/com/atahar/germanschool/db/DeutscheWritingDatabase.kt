package com.atahar.germanschool.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.atahar.germanschool.db.dao.LettersDao
import com.atahar.germanschool.db.entity.LetterModel
import com.atahar.germanschool.workers.DBInsertWorker

@Database(entities = [LetterModel::class], version = 1, exportSchema = false)
abstract class DeutscheWritingDatabase : RoomDatabase() {

    abstract val lettersDao: LettersDao

    private class DeutscheWritingDatabaseCallback(
        private val context: Context
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val request = OneTimeWorkRequestBuilder<DBInsertWorker>().build()
            WorkManager.getInstance(context).enqueue(request)
        }
    }

    companion object {

        private var INSTANCE: DeutscheWritingDatabase? = null

        fun getInstance(context: Context): DeutscheWritingDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DeutscheWritingDatabase::class.java,
                        "german_school_database"
                    )
                        .addCallback(DeutscheWritingDatabaseCallback(context))
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }

    }
}
