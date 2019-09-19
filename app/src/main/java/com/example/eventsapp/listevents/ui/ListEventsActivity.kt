package com.example.eventsapp.listevents.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import com.example.eventsapp.eventdetail.ui.EventDetailActivity
import com.example.eventsapp.listevents.viewmodel.ListEventsViewModel
import kotlinx.android.synthetic.main.activity_list_events.*
import org.koin.android.viewmodel.ext.android.viewModel
import com.example.eventsapp.R



class ListEventsActivity : AppCompatActivity() {

    private val viewModel: ListEventsViewModel by viewModel()

    lateinit var adapter: EventListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_events)

        initViews()
    }

    private fun initViews() {
        setupAdapter()
        observeViewModel()
        toolbar.setTitle("Events")

        fab_add.setOnClickListener {
            val intent = Intent(this@ListEventsActivity, EventDetailActivity::class.java)
            startActivity(intent)
        }





        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter.filter(newText)
                return true
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                adapter.filter.filter(query)
                return true
            }
        })

    }

    fun onQueryTextSubmit(query: String): Boolean {
        adapter.filter.filter(query)

        return true
    }

    fun onQueryTextChange(newText: String): Boolean {
        adapter.filter.filter(newText)
        return true
    }

    override fun onStart() {
        super.onStart()
        viewModel.getEventsList()
        adapter.notifyDataSetChanged()
    }

    private fun observeViewModel() {
        viewModel.eventsList.observe(
            this,
            Observer { eventList ->
               // adapter.submitList(eventList)
                adapter.updateEventList(eventList)
            }
        )
    }

    private fun setupAdapter() {
        adapter = EventListAdapter()
        rv_events.adapter = adapter
    }
}
