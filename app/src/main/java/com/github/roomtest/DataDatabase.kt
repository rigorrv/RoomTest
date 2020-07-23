package com.github.roomtest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [WorkData11::class], version = 1, exportSchema = false)
abstract class DataDatabase : RoomDatabase() {
    abstract fun dataDAO(): DataDAO?

    companion object {
        private const val DB_NAME = "DataDb"
        private var instance: DataDatabase? = null

        @Synchronized
        fun getInstance(context: Context?): DataDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context!!,
                    DataDatabase::class.java, DB_NAME
                )
                    .allowMainThreadQueries().build()
            }
            return instance
        }
    }
}