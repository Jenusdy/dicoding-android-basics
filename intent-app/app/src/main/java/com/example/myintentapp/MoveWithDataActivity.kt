package com.example.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    private lateinit var textViewDataRecieved : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        textViewDataRecieved = findViewById(R.id.tv_data_received)

        val name = intent.getStringExtra("extra_name")
        val age = intent.getIntExtra("extra_age", 0)

        val text = "Nama $name, You age $age"
        textViewDataRecieved.text = text
    }
}