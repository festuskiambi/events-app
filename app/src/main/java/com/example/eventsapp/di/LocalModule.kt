package com.example.eventsapp.di

import androidx.room.Room
import com.example.eventsapp.data.local.EventsAppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Festus Kiambi on 7/3/19.
 */

val localModule = module {
    single {
        Room.databaseBuilder(androidContext(), EventsAppDatabase::class.java, "EventsApp.db")
            .build()
    }

    single { (get<EventsAppDatabase>().eventsDao()) }
}