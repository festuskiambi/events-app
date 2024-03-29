package com.example.eventsapp.eventdetail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventsapp.domain.entities.Event
import com.example.eventsapp.domain.usecases.IEventUseCase
import com.example.rockstars.common.AppDispatchers
import kotlinx.coroutines.launch
import java.util.*


/**
 * Created by Festus Kiambi on 9/19/19.
 */

class EventDetailViewModel(
    private val eventsUseCase: IEventUseCase,
    private val dispatchers: AppDispatchers
) : ViewModel() {

    fun saveEvent(
        id: String,
        title: String,
        startDate: String,
        endDate: String,
        startTime: String,
        endTime: String
    ) = viewModelScope.launch(dispatchers.io) {
        val event = Event(id,title,startDate,endDate,startTime,endTime)

        eventsUseCase.createEvent(event)
    }

    fun deleteEvent(event: Event) = viewModelScope.launch(dispatchers.io) {
         eventsUseCase.deleteEvent(event)
    }

}