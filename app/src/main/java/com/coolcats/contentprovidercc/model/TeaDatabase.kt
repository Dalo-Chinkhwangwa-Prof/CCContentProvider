package com.coolcats.contentprovidercc.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Tea::class], version = 1)
abstract class TeaDatabase : RoomDatabase() {
    abstract fun getDAO(): TeaDAO
    companion object {
        lateinit var teaDatabase: TeaDatabase
        fun create(context: Context) {
            teaDatabase =
                Room.databaseBuilder(
                    context,
                    TeaDatabase::class.java,
                    "tea.db"
                ).allowMainThreadQueries()
                    .build()
        }
    }
}