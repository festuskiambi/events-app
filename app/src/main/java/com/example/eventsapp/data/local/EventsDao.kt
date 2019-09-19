package com.example.eventsapp.data.local

import androidx.room.*
import com.example.eventsapp.data.datamodels.RoomEvent

/**
 * Created by Festus Kiambi on 9/19/19.
 */
@Dao
interface EventsDao {

    @Query("SELECT * FROM events")
    fun getEvents(): List<RoomEvent>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvent(event: RoomEvent)

    @Delete
    fun deleteEvent(event: RoomEvent)
}