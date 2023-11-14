package io.github.jenusdy.shared_preferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        val btnSave: Button = findViewById(R.id.btn_save)
        val btnLoad: Button = findViewById(R.id.btn_load)
        val etName: EditText = findViewById(R.id.et_name)
        val etAge: EditText = findViewById(R.id.et_age)
        val cbAdult: CheckBox = findViewById(R.id.cb_adult)

        btnSave.setOnClickListener {
            val name: String = etName.text.toString();
            val age: Int = etAge.text.toString().toInt();
            val isAdult: Boolean = cbAdult.isChecked

            editor.apply {
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply()
            }
        }

        btnLoad.setOnClickListener {
            val name = sharedPref.getString("name", null)
            val age = sharedPref.getInt("age", 0)
            val isAdult = sharedPref.getBoolean("isAdult", false)

            Log.d("MainActivity", name.toString())

            etName.setText(name)
            etAge.setText(age.toString())
            cbAdult.isChecked = isAdult
        }

    }
}