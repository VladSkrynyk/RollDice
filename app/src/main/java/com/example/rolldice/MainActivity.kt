package com.example.rolldice

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.rolldice.databinding.ActivityMainBinding
import com.example.rolldice.viewmodel.DiceViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: DiceViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.diceSides.observe(this, Observer { diceModel ->
            diceModel.sides.forEachIndexed { index, side ->
                val resId = resources.getIdentifier("dice_$side", "drawable", packageName)
                when (index) {
                    0 -> binding.dice1.setImageResource(resId)
                    1 -> binding.dice2.setImageResource(resId)
                    2 -> binding.dice3.setImageResource(resId)
                    3 -> binding.dice4.setImageResource(resId)
                    4 -> binding.dice5.setImageResource(resId)
                }
            }
        })

        binding.startButton.setOnClickListener { viewModel.startRolling() }
        binding.stopButton.setOnClickListener { viewModel.stopRolling() }
    }
}
