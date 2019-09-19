package com.example.eventsapp.listevents.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.eventsapp.R
import com.example.eventsapp.domain.entities.Event
import com.example.eventsapp.eventdetail.ui.EventDetailActivity
import kotlinx.android.synthetic.main.item_event.view.*


/**
 * Created by Festus Kiambi on 9/19/19.
 */
class EventListAdapter :
    ListAdapter<Event, EventListAdapter.EventViewHolder>(EventDiffCallBack()), Filterable {

    private lateinit var eventList: MutableList<Event>
    lateinit var eventListCopy: List<Event>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EventViewHolder(
            inflater.inflate(R.layout.item_event, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
            val event = eventList[position]
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

    override fun getItemCount(): Int {
        return if (::eventList.isInitialized) eventList.size else 0
    }

    class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.tv_title
        val startDateTime: TextView = view.tv_start_date_time
        val endDateTime: TextView = view.tv_end_date_time
    }

    fun updateEventList(eventsList : List<Event>){

        this.eventList = eventsList as MutableList<Event>
        this.eventListCopy = ArrayList<Event>(eventList)
        notifyDataSetChanged()

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val filteredList = ArrayList<Event>()

                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    filteredList.addAll(eventListCopy)
                } else {
                    for (event in eventListCopy) {
                        if (event.title!!.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(event)
                        }
                    }
                }
                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                eventList.clear()
                eventList = filterResults.values as ArrayList<Event>
                notifyDataSetChanged()
            }
        }
    }
}