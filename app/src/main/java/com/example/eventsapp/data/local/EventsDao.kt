package com.example.eventsapp.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eventsapp.data.datamodels.RoomEvent

/**
 * Created by Festus Kiambi on 9/19/19.
 */
interface EventsDao {

    @Query("SELECT * FROM events")
    fun getEvents(): List<RoomEvent>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvent(event: RoomEvent)

    @Delete
    fun deleteEvent()
}