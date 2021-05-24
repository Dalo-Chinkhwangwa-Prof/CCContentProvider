package com.coolcats.contentprovidercc.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.util.Log
import com.coolcats.contentprovidercc.model.TeaDatabase

class TeaProvider: ContentProvider(){

    private val authority = "com.coolcats.contentprovidercc"
    private val MULTIPLE = 0
    private val SINGLE = 1

    //content://user_dictionary/words
    //content://com.coolcats.contentprovidercc/tea/#
    //content://com.coolcats.contentprovidercc/tea

    val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).also {
        it.addURI(
            authority,
            "tea/#",
            SINGLE
        )
        it.addURI(
            authority,
            "tea",
            MULTIPLE
        )
    }


    override fun onCreate(): Boolean {
        Log.d("TAG_X", "onCreate....Thread ${Thread.currentThread().name}")
        return true
    }

    override fun query(
        uri: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        var cursor: Cursor? = null
        when(uriMatcher.match(uri)){
            MULTIPLE -> {
                cursor = TeaDatabase.teaDatabase.getDAO().getAllTea()
            }
            SINGLE -> {
                val id = uri.pathSegments[1].toInt()
                Log.d("TAG_X", "id... $id")
                cursor = TeaDatabase.teaDatabase.getDAO().getTeaItem(id)
            }
        }
        return cursor
    }

    override fun getType(p0: Uri): String? {
        return null
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        return null
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        return 0
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        return 0
    }
}