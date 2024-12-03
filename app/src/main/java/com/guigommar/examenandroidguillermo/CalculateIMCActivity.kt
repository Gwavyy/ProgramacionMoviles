package com.guigommar.examenandroidguillermo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.guigommar.examenandroidguillermo.databinding.ActivityCalculateImcBinding

class CalculateIMCActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculateImcBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculateImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            val weight = binding.etWeight.text.toString().toDoubleOrNull()
            val height = binding.etHeight.text.toString().toDoubleOrNull()

            if (weight != null && height != null && height > 0) {
                val imc = weight / (height * height)
                val category = when {
                    imc < 18.5 -> "Inferior al normal"
                    imc < 25 -> "Normal"
                    imc < 30 -> "Sobrepeso"
                    else -> "Obesidad"
                }
                binding.tvResult.text = "IMC: %.2f - %s".format(imc, category)
            } else {
                binding.tvResult.text = "Por favor, ingresa datos válidos."
            }
        }
    }
}
