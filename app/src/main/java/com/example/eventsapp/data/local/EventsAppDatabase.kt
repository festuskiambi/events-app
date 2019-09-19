package com.example.eventsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.eventsapp.data.datamodels.RoomEvent

/**
 * Created by Festus Kiambi on 9/19/19.
 */
@Database(entities = [RoomEvent::class], version = 1, exportSchema = false)
abstract class EventsAppDatabase  : RoomDatabase() {

    abstract fun eventsDao(): EventsDao
}