package com.pushpak.sensor

abstract class MesaurableSensor (
    protected val sensorType:Int
) {

    protected var onSensorValueChanged: ((List<Float>) -> Unit)? = null
    abstract val doesSensorExist: Boolean

    abstract fun startListening()
    abstract fun stopListening()

    fun setOnSensorValueChangedListener(listener : (List<Float>) -> Unit) {
        onSensorValueChanged = listener
    }
}