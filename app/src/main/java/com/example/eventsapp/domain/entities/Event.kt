package com.example.eventsapp.domain.entities

import java.io.Serializable

/**
 * Created by Festus Kiambi on 9/18/19.
 */
data class Event (
    val id: String,
    val title: String,
    val startDate: String,
    val endDate: String,
    val startTime: String,
    val endTime: String
): Serializable