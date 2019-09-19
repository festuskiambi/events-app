package com.example.eventsapp.listevents.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventsapp.domain.entities.Event
import com.example.eventsapp.domain.usecases.IEventUseCase
import com.example.rockstars.common.AppDispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by Festus Kiambi on 9/19/19.
 */
class ListEventsViewModel(
    private val eventsUseCase: IEventUseCase,
    private val dispatchers: AppDispatchers
) : ViewModel() {

    private val eventListState = MutableLiveData<List<Event>>()
    val eventsList: LiveData<List<Event>> get() = eventListState

    init {
        getEventsList()
    }

     fun getEventsList()=viewModelScope.launch(dispatchers.io) {
        val result = eventsUseCase.getEvents()
            eventListState.postValue(result)
    }
}