package com.example.eventsapp.listevents.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.eventsapp.domain.entities.Event

/**
 * Created by Festus Kiambi on 9/19/19.
 */

class EventDiffCallBack : DiffUtil.ItemCallback<Event>(){
    override fun areItemsTheSame(oldItem:Event, newItem: Event): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem.id == newItem.id
    }

}