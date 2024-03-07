package com.example.view_model_example

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.view_model_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        binding.btnHitung.setOnClickListener {
            val width = binding.tvLebar.text.toString()
            val height = binding.tvPanjang.text.toString()
            val length = binding.tvTinggi.text.toString()
            when {
                width.isEmpty() -> {
                    binding.tvLebar.error = "Masih kosong"
                }

                height.isEmpty() -> {
                    binding.tvPanjang.error = "Masih kosong"
                }

                length.isEmpty() -> {
                    binding.tvTinggi.error = "Masih kosong"
                }

                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        binding.tvResult.text = viewModel.result.toString()
    }
}