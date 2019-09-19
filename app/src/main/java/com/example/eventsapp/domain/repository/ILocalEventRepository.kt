package com.example.eventsapp.domain.repository

import com.example.eventsapp.domain.entities.Event

/**
 * Created by Festus Kiambi on 9/19/19.
 */

interface ILocalEventRepository {

    suspend fun getEvents() : List<Event>

    suspend fun editEvent(id: String)

    suspend fun deleteEvent(event: Event)
}