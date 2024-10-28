package com.example.rolldice

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rolldice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        
        binding.buttonStart.setOnClickListener{
            Log.d(TAG, "onCreate: Timer starts ")
            startTimer( 20_000, 1_000)
            
        }

        viewModel.timerLiveData.observe(this) { currentTime: Long ->
            binding.textViewTime.text = (currentTime / 1000).toInt().toString()

        }
    }

    private fun startTimer(start: Long, step: Long) {
        viewModel.startTimer(20_000, 1_000)
    }
    
    companion object {
        val TAG = "XXXX"
    }
}