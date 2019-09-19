package com.example.eventsapp.eventdetail.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.eventsapp.R
import com.example.eventsapp.domain.entities.Event
import kotlinx.android.synthetic.main.item_event.view.*


/**
 * Created by Festus Kiambi on 9/19/19.
 */
class EventListAdapter :
    ListAdapter<Event, EventListAdapter.EventViewHolder>(EventDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EventViewHolder(
            inflater.inflate(R.layout.item_event, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        getItem(position).let { event ->
            val startDate = "${event.startDate} @ ${event.startTime}"
            val endDate = "${event.endDate} @ ${event.endTime}"
            holder.title.text = event.title
            holder.startDateTime.text = startDate
            holder.endDateTime.text = endDate

            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context, EventDetailActivity::class.java)
                intent.putExtra("value", event)
                startActivity(holder.itemView.context, intent, null)
            }
        }
    }

    class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.tv_title
        val startDateTime: TextView = view.tv_start_date_time
        val endDateTime: TextView = view.tv_end_date_time
    }
}