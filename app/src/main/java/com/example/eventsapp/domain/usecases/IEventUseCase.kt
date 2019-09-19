package com.example.eventsapp.domain.usecases

import com.example.eventsapp.domain.entities.Event

/**
 * Created by Festus Kiambi on 9/19/19.
 */
interface IEventUseCase {
    suspend fun createEvent(event: Event)

    suspend fun getEvents() : List<Event>

    suspend fun editEvent(event: Event)

    suspend fun deleteEvent(event: Event)
}