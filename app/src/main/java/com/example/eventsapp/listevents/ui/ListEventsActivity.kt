package com.example.eventsapp.listevents.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventsapp.R
import com.example.eventsapp.eventdetail.ui.EventDetailActivity
import com.example.eventsapp.listevents.viewmodel.ListEventsViewModel
import kotlinx.android.synthetic.main.activity_list_events.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListEventsActivity : AppCompatActivity() {

    private val viewModel: ListEventsViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_events)

        initViews()
    }

    private fun initViews() {
        fab_add.setOnClickListener {
            val intent = Intent(this@ListEventsActivity, EventDetailActivity::class.java)
            startActivity(intent)
        }
    }
}
