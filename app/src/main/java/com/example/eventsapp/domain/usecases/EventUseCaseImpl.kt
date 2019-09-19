package com.example.eventsapp.domain.usecases

import com.example.eventsapp.domain.entities.Event
import com.example.eventsapp.domain.repository.ILocalEventRepository
import com.example.eventsapp.domain.repository.IRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Festus Kiambi on 9/19/19.
 */
class EventUseCaseImpl(private val localRepository: ILocalEventRepository,
                       private val remoteRepository: IRemoteRepository) : IEventUseCase {
    override suspend fun createEvent(event: Event) {
        localRepository.createEvent(event)
    }

    override suspend fun getEvents(): List<Event>  {
       return localRepository.getEvents()
    }

    override suspend fun editEvent(event: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteEvent(event: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}