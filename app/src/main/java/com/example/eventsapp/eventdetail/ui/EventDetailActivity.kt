package com.example.eventsapp.eventdetail.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventsapp.R
import com.example.eventsapp.domain.entities.Event
import com.example.eventsapp.eventdetail.viewmodel.EventDetailViewModel
import kotlinx.android.synthetic.main.activity_event_detail.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class EventDetailActivity : AppCompatActivity() {

    private lateinit var event: Event
    private val viewModel: EventDetailViewModel by viewModel()
    private var id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        initViews()
    }

    private fun initViews() {

        try {
            event = intent.getSerializableExtra("value") as Event
            id = event.id
            populateViewCurrentEventDetails()

            imb_toolbar_delete.setOnClickListener {
                viewModel.deleteEvent(event)
                onBackPressed()
            }
        }catch (e: TypeCastException){
            val uuid = UUID.randomUUID()
             id = uuid.toString()
        }


        imb_toolbar_done.setOnClickListener {
            initiateSaveEvent()
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel
    }

    private fun populateViewCurrentEventDetails() {
        et_title.setText(event.title)
        et_start_date.setText(event.startDate)
        et_end_date.setText(event.endDate)
        et_start_time.setText(event.startTime)
        et_end_time.setText(event.endTime)
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

        viewModel.saveEvent(id,title,startDate,endDate,startTime,endTime)
        onBackPressed()
    }
}
