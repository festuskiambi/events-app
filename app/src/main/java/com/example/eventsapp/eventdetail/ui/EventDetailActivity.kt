package com.example.eventsapp.eventdetail.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventsapp.R
import kotlinx.android.synthetic.main.activity_event_detail.*

class EventDetailActivity : AppCompatActivity() {

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
    }
}
