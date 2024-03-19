package io.github.jenusdy.simple_clean_architecture.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import io.github.jenusdy.simple_clean_architecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = MainViewModelFactory.getInstance()
        val viewModel  = ViewModelProvider(this, factory)[MainViewModel::class.java]
        viewModel.setName("Jenusdy")
        viewModel.message.observe(this) {
            binding.tvWelcome.text = it.message
        }
    }
}