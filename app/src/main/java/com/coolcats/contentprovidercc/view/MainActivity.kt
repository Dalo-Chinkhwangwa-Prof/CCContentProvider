package com.coolcats.contentprovidercc.view

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.coolcats.contentprovidercc.R
import com.coolcats.contentprovidercc.model.Tea
import com.coolcats.contentprovidercc.model.TeaDatabase

class MainActivity : AppCompatActivity() {
    @SuppressLint("Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //content://com.coolcats.contentprovidercc/tea/#
        //content://com.coolcats.contentprovidercc/tea
        val uri = Uri.parse("content://com.coolcats.contentprovidercc/tea")
        val tea = contentResolver.query(
            uri,
            null,
            null,
            null,
            null,
            null
        )

        tea?.moveToPosition(-1)

        var size = 0
        while(tea?.moveToNext() == true){
            Log.d("TAG_X", "Tea: ${tea.getString(1)}")
        }
    }
}