package com.example.cardinformer.core.app

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CardInformerApp: Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: CardInformerApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}