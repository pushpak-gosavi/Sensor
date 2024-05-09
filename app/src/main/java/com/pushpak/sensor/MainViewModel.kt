package com.pushpak.sensor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val lightSensor: MesaurableSensor
) : ViewModel(){

    var isdark by mutableStateOf(false)
    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValueChangedListener { values ->
            val lux = values[0]
            isdark = lux < 60f
        }
    }
}