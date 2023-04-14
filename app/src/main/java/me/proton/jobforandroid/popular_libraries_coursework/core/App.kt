package me.proton.jobforandroid.popular_libraries_coursework.core

import android.app.Application
import me.proton.jobforandroid.popular_libraries_coursework.di.AppComponent
import me.proton.jobforandroid.popular_libraries_coursework.di.AppModule
import me.proton.jobforandroid.popular_libraries_coursework.di.DaggerAppComponent



class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()

    }
}