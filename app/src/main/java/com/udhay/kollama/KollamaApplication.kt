package com.udhay.kollama

import android.app.Application
import com.udhay.kollama.core.di.KollamaApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.plugin.module.dsl.startKoin


class KollamaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin<KollamaApp>{
            androidLogger()
            androidContext(this@KollamaApplication)
        }
    }
}