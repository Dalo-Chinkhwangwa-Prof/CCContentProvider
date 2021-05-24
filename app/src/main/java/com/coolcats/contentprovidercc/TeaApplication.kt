package com.coolcats.contentprovidercc

import android.app.Application
import com.coolcats.contentprovidercc.model.TeaDatabase

class TeaApplication: Application() {


    override fun onCreate() {
        super.onCreate()
        TeaDatabase.create(this)
    }
}