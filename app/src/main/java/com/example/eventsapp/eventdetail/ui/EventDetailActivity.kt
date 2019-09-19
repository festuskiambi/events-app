package com.example.eventsapp.eventdetail.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventsapp.R
import com.example.eventsapp.domain.entities.Event
import com.example.eventsapp.eventdetail.viewmodel.EventDetailViewModel
import kotlinx.android.synthetic.main.activity_event_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class EventDetailActivity : AppCompatActivity() {

    private lateinit var event: Event
    private val viewModel: EventDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        initViews()
    }

    private fun initViews() {
        imb_toolbar_done.setOnClickListener {
            initiateSaveEvent()
        }
    }

    private fun initiateSaveEvent() {
        val title = et_title.text.toString().trim()
        val startDate = et_start_date.text.toString().trim()
        val endDate = et_end_date.text.toString().trim()
        val startTime = et_start_time.text.toString().trim()
        val endTime = et_end_time.text.toString().trim()

        if(title.isBlank()) et_title.error = "required"
        if(startDate.isBlank()) et_start_date.error = "required"
        if(endDate.isBlank()) et_end_date.error = "required"
        if(startTime.isBlank()) et_start_time.error = "required"
        if(endTime.isBlank()) et_end_time.error = "required"

        viewModel.saveEvent(title,startDate,endDate,startTime,endTime)
    }
}
