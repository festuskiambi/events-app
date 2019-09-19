package com.example.eventsapp.data.local

import com.example.eventsapp.data.toEntityEventList
import com.example.eventsapp.data.toRoomvent
import com.example.eventsapp.domain.entities.Event
import com.example.eventsapp.domain.repository.ILocalEventRepository

/**
 * Created by Festus Kiambi on 9/19/19.
 */
class LocalEventRepositoryImpl(private val eventsDao: EventsDao) : ILocalEventRepository {
    override suspend fun createEvent(event: Event) {
        eventsDao.insertEvent(event.toRoomvent)
    }

    override suspend fun getEvents(): List<Event> {
        return eventsDao.getEvents().toEntityEventList()
    }


    override suspend fun deleteEvent(event: Event) {
        eventsDao.deleteEvent(event.toRoomvent)
    }
}