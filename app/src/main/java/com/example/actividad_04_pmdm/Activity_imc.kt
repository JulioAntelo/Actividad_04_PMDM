package com.example.actividad_04_pmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider


class Activity_imc : AppCompatActivity() {
    val buttonIdList = listOf(R.id.edadMinus,R.id.edadPlus,R.id.pesoMinus,R.id.pesoPlus)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        val heightTextView = findViewById<TextView>(R.id.sliderTextView)
        val slider = findViewById<RangeSlider>(R.id.slider)


        slider.addOnChangeListener{_,value,_->
            heightTextView.text = "${value.toInt()} cm"
        }




    }
//    fun buttons(button: FloatingActionButton){
//        when(button.id){
//            R.id.edadMinus ->{
//
//            }
//        }
//    }


}