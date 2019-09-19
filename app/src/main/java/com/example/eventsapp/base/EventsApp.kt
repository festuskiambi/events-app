package com.example.eventsapp.base

import android.app.Application
import com.example.eventsapp.di.eventsModule
import com.example.eventsapp.di.localModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Festus Kiambi on 9/19/19.
 */
class EventsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@EventsApp)
            // declare modules
            modules(listOf(localModule,eventsModule))
        }

    }
}