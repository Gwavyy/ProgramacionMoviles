package com.guigommar.examenandroidguillermo

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.guigommar.examenandroidguillermo.databinding.ActivityListSensorsBinding

class ListSensorsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListSensorsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListSensorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensors = sensorManager.getSensorList(Sensor.TYPE_ALL)

        val sensorNames = sensors.joinToString("\n") { it.name }
        binding.tvSensors.text = sensorNames
    }
}
