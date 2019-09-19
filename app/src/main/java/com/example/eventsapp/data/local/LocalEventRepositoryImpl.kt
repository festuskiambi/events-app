package com.example.eventsapp.data.local

import com.example.eventsapp.domain.entities.Event
import com.example.eventsapp.domain.repository.ILocalEventRepository

/**
 * Created by Festus Kiambi on 9/19/19.
 */
class LocalEventRepositoryImpl() : ILocalEventRepository {
    override suspend fun getEvents(): List<Event> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun editEvent(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteEvent(event: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}