package com.coolcats.contentprovidercc.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "tea")
data class Tea(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name  = "name")
    val name: String,
    @ColumnInfo(name  = "country")
    val country: String,
    @ColumnInfo(name ="rating")
    val rating: Int){
    @Ignore
    constructor(name: String, country: String, rating: Int): this(0, name, country, rating)
}
