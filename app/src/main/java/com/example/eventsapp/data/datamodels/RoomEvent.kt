package com.example.eventsapp.data.datamodels

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

/**
 * Created by Festus Kiambi on 9/19/19.
 */
class RoomEvent (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "startDate")
    val startDate: String,

    @ColumnInfo(name = "endDate")
    val endDate: String,

    @ColumnInfo(name = "startTime")
    val startTime: String,

    @ColumnInfo(name = "endTime")
    val endTime: String
)