package com.example.actividad_04_pmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.slider.RangeSlider


class Activity_imc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        val slider = findViewById<RangeSlider>(R.id.slider)
        val sliderTextview = findViewById<TextView>(R.id.sliderTextView)

        slider.valueTo = 100F

        slider.addOnChangeListener{_,value,_ ->

            sliderTextview.text = "${value.toInt()+120} cm"

        }


    }


}