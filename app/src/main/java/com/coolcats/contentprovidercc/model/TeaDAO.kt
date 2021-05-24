package com.coolcats.contentprovidercc.model

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TeaDAO {

    @Insert
    fun insertTea(vararg tea: Tea)

    @Query("SELECT * FROM tea")
    fun getAllTea(): Cursor

    @Query("SELECT * FROM tea WHERE id = :id")
    fun getTeaItem(id: Int): Cursor

}