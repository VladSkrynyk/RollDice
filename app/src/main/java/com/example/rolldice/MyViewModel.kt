package com.example.rolldice

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rolldice.MainActivity.Companion.TAG

class MyViewModel : ViewModel() {
    val _timerLiveData : MutableLiveData<Long> = MutableLiveData(0)
    val timerLiveData: LiveData<Long>
        get() = _timerLiveData

    fun startTimer(start: Long, step: Long) {
        object : CountDownTimer(start, step) {

            override fun onTick(millisUntilFinished: Long) {
                // binding.textViewTime.text = (millisUntilFinished / 1000).toInt().toString()
                //activity.binding.textViewTime.text = (millisUntilFinished / 1000).toInt().toString()

                _timerLiveData.value = millisUntilFinished
                Log.d(TAG, "onTick: $millisUntilFinished")
            }

            override fun onFinish() {
                // binding.textViewTime.text = "Time is over"
                //activity.binding.textViewTime.text = "Time is over"

                Log.d(TAG, "onFinish: timer is over")
            }
        }.start()

    }
}