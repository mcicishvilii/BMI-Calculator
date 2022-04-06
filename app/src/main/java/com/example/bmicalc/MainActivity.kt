package com.example.bmicalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etHeight:EditText = findViewById(R.id.ET_your_height)
        val etWeight:EditText = findViewById(R.id.ET_your_weight)
        val caclButton:Button = findViewById(R.id.BTN_calculate)
        val twYourBmi:TextView = findViewById(R.id.TW_result_text)
        val IVstatus:ImageView = findViewById(R.id.IW_status_pic)

        caclButton.setOnClickListener {
            val yourBMI = calcBMI(etHeight.text.toString().toDouble(),etWeight.text.toString().toDouble())
            if (yourBMI < 25){
                IVstatus.setImageResource(R.drawable.ic__chama)
            }else{
                IVstatus.setImageResource((R.drawable.ic__sirbili))
            }
            twYourBmi.text = yourBMI.toString()
        }
    }
    private fun calcBMI(height: Double, mass: Double): Double {
        return mass / (height * 100).pow(2)
    }
}

