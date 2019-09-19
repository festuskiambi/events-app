package com.example.eventsapp.data

import com.example.eventsapp.data.datamodels.RoomEvent
import com.example.eventsapp.domain.entities.Event

/**
 * Created by Festus Kiambi on 9/19/19.
 */
internal val Event.toRoomvent: RoomEvent
get() = RoomEvent(
    this.id,
    this.title,
    this.startDate,
    this.endDate,
    this.startTime,
    this.endTime
)

internal val RoomEvent.toEntityEvent: Event
    get() = Event(
        this.id,
        this.title,
        this.startDate,
        this.endDate,
        this.startTime,
        this.endTime
    )

internal fun List<RoomEvent>.toEntityEventList(): List<Event> = this.flatMap {
    listOf(it.toEntityEvent)
}



