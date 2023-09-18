package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var buttonMoveNoData: Button
    private lateinit var buttonMoveWithData: Button
    private lateinit var buttonMoveWithObject: Button
    private lateinit var buttonDialNumber: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        buttonMoveNoData = findViewById(R.id.btn_move_activity)
        buttonMoveNoData.setOnClickListener(this)

        buttonMoveWithData = findViewById(R.id.btn_move_activity_data)
        buttonMoveWithData.setOnClickListener(this)

        buttonMoveWithObject = findViewById(R.id.btn_move_activity_object)
        buttonMoveWithObject.setOnClickListener(this)

        buttonDialNumber = findViewById(R.id.btn_dial_number)
        buttonDialNumber.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val intent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_move_activity_data -> {
                val intent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                intent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Fawcet Jenusdy Makay")
                intent.putExtra(MoveWithDataActivity.EXTRA_AGE, 26)
                startActivity(intent)
            }
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "DicodingAcademy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                )
                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "081210841382"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}